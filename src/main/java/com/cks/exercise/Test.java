package com.cks.exercise;

import com.cks.exercise.linkedList.LinkList;

/**
 * @Author: cks
 * @Date: Created by 15:22 2018/8/29
 * @Package: com.cks.exercise
 * @Description:
 */
public class Test {

    private static volatile Test instance;

    private Test() {
    }

    public static Test init() {
        if (instance == null) {
            synchronized (Test.class) {
                if (instance == null) {
                    return new Test();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        LinkList linkList = new LinkList();
        linkList.add(1);
        linkList.add(2);
        linkList.add("aaa");
        linkList.add("bbb");
        System.out.println(linkList.size());

//        linkList.add(2, "add");
//        linkList.remove(5);
        linkList.reverseBetween(2, 4);
        linkList.printAll();
    }

}
