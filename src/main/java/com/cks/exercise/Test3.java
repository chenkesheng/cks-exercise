package com.cks.exercise;

public class Test3 {

    /**
     * 2、用2种方式 实现 单例
     */
    private volatile static Test3 instance;

    private void Test3() {

    }


    public Test3 getInstance() {
        if (null == instance) {
            synchronized (Test3.class) {
                if (null == instance) {
                    instance = new Test3();
                }
            }
        }
        return instance;
    }
}
