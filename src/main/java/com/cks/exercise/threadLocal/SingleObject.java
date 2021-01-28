package com.cks.exercise.threadLocal;

/**
 * @Author: cks
 * @Date: Created by 上午9:44 2021/1/28
 * @Package: com.cks.exercise.threadLocal
 * @Description:
 */
public class SingleObject {
    private static volatile SingleObject singleObject;

    private final ThreadLocal<Integer> threadLocal;

    private SingleObject() {
        threadLocal = new ThreadLocal<>();
    }

    public static SingleObject getInstance() {
        if (singleObject == null) {
            synchronized (SingleObject.class) {
                if (singleObject == null) {
                    singleObject = new SingleObject();
                }
                return singleObject;
            }
        }
        return singleObject;
    }

    public void setValue(Integer x) {
        threadLocal.set(x);
    }

    public Integer getValue() {
        return threadLocal.get();
    }


    public static void main(String[] args) throws InterruptedException {
        SingleObject singleObject = SingleObject.getInstance();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                singleObject.setValue(1);
                System.out.println("线程1把值设置为1");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1中的值为" + singleObject.getValue());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                singleObject.setValue(1000);
                System.out.println("线程2把值设置为1000");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2中的值为" + singleObject.getValue());
            }
        });
        thread1.start();
        Thread.sleep(1000L);
        thread2.start();
    }

}
