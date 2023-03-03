package com.cks.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    private static int i;

    public static void add() {
        i++;
        System.out.println(i);
    }

    public static void subtract() {
        i--;
        System.out.println(i);
    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(() -> add());
//        Thread thread2 = new Thread(() -> add());
//        Thread thread3 = new Thread(() -> subtract());
//        Thread thread4 = new Thread(() -> subtract());
//        thread1.start();
//        thread1.join();
//
//        thread2.start();
//        thread2.join();
//
//        thread3.start();
//        thread3.join();
//
//        thread4.start();
//        thread4.join();
//    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        TestLock testLock = new TestLock();
        Runnable a = testLock::testThread1;
        Runnable b = testLock::testThread2;
        Runnable c = testLock::testThread3;
        Runnable d = testLock::testThread4;
        executorService.execute(a);
        executorService.execute(b);
        executorService.execute(c);
        executorService.execute(d);
        executorService.shutdown();
    }


    static class TestLock {
        private static final ReentrantLock lock = new ReentrantLock();
        private final Condition condition1 = lock.newCondition();
        private final Condition condition2 = lock.newCondition();
        private final Condition condition3 = lock.newCondition();
        private final Condition condition4 = lock.newCondition();

        private int i;

        public void testThread1() {
            lock.lock();
            try {
//                condition1.await();
                i++;
                System.out.println(i);
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void testThread2() {
            lock.lock();
            try {
//                condition2.await();
                i++;
                System.out.println(i);
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void testThread3() {
            lock.lock();
            try {
//                condition3.await();
                i--;
                System.out.println(i);
                condition4.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void testThread4() {
            lock.lock();
            try {
//                condition4.await();
                i--;
                System.out.println(i);
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
