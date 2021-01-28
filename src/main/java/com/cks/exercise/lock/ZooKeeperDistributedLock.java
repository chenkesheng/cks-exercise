package com.cks.exercise.lock;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: cks
 * @Date: Created by 上午9:39 2021/1/25
 * @Package: com.cks.exercise.lock
 * @Description:
 */
public class ZooKeeperDistributedLock implements Watcher {

    public static void main(String[] args) {
        // 并发数
        int currency = 10;

        // 循环屏障
        final CyclicBarrier cb = new CyclicBarrier(currency);

        // 多线程模拟高并发
        for (int i = 0; i < currency; i++) {
            new Thread(new Runnable() {
                public void run() {

                    System.out.println(Thread.currentThread().getName() + "已准备好");
                    // 等待一起出发
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    ZooKeeperDistributedLock lock = new ZooKeeperDistributedLock("1");

                    try {
                        lock.acquireDistributedLock();
                        System.out.println(Thread.currentThread().getName() + " 获得锁！");
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }


    private ZooKeeper zk;
    private final String locksRoot = "/locks";
    private ZkClient client;
    private final String productId;
    private String waitNode;
    private String lockNode;
    private CountDownLatch latch;
    private final CountDownLatch connectedLatch = new CountDownLatch(1);
    private final int sessionTimeout = 30000;

    public ZooKeeperDistributedLock(String productId) {
        this.productId = productId;
        try {
            String address = "127.0.0.1:2181";
            client = new ZkClient(address);
//            if (!this.client.exists(locksRoot)) {
//                try {
//                    this.client.(locksRoot);
//                } catch (ZkNodeExistsException e) {
//                    e.printStackTrace();
//                }
//            }
            zk = new ZooKeeper(address, sessionTimeout, this);
            connectedLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            connectedLatch.countDown();
            return;
        }
        if (this.latch != null) {
            this.latch.countDown();
        }
    }

    public void acquireDistributedLock() {
        try {
            if (this.tryLock()) {
                return;
            } else {
                waitForLock(waitNode, sessionTimeout);
            }
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean tryLock() {
        try {
            // 传入进去的locksRoot + “/” + productId
            // 假设productId代表了一个商品id，比如说1
            // locksRoot = locks
            // /locks/10000000000，/locks/10000000001，/locks/10000000002
            lockNode = zk.create(locksRoot + "/" + productId, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            // 看看刚创建的节点是不是最小的节点
            // locks：10000000000，10000000001，10000000002
            System.out.println(lockNode);
            List<String> locks = zk.getChildren(locksRoot, false);
            Collections.sort(locks);
            if (lockNode.equals(locksRoot + "/" + locks.get(0))) {
                //如果是最小的节点,则表示取得锁
                return true;
            }
            //如果不是最小的节点，找到比自己小1的节点
            int previousLockIndex = -1;
            for (int i = 0; i < locks.size(); i++) {
                if (lockNode.equals(locksRoot + "/" + locks.get(i))) {
                    previousLockIndex = i - 1;
                    break;
                }
            }
            this.waitNode = locks.get(previousLockIndex);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean waitForLock(String waitNode, long waitTime) throws InterruptedException, KeeperException {
        Stat stat = zk.exists(locksRoot + "/" + waitNode, true);
        if (stat != null) {
            this.latch = new CountDownLatch(1);
            this.latch.await(waitTime, TimeUnit.MILLISECONDS);
            this.latch = null;
        }
        return true;
    }

    public void unlock() {
        try {
            // 删除/locks/10000000000节点
            // 删除/locks/10000000001节点
            System.out.println("unlock " + lockNode);
            zk.delete(lockNode, -1);
            lockNode = null;
            zk.close();
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }

    }
}