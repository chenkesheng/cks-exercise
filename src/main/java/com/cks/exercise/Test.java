package com.cks.exercise;

import com.cks.exercise.linkedList.CycleLinkedList;
import com.cks.exercise.linkedList.DoublyLinkedList;
import com.cks.exercise.linkedList.LinkList;

import java.util.LinkedList;

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
//        LinkList<Object> linkList = new LinkList<>();
////        linkList.add("abc");
////        linkList.add("aaa");
//        linkList.add(1);
//        linkList.add(1);
////        linkList.add("aaa");
////        linkList.add("bbb");
//        linkList.add(1);
//        linkList.add(2);
//        linkList.add(2);
//        linkList.add(3);
//        linkList.add(6);
//        linkList.dup();
////        System.out.println(linkList.size());
////        linkList.printAll();
//        for (int i = 0; i < linkList.size(); i++) {
//            System.out.println(linkList.get(i));
//        }
//        linkList.add(2, "add");
//        linkList.remove(5);
//        linkList.reverseBetween(2, 4);
//        linkList.printAll();

//        CycleLinkedList<Object> linkedList = new CycleLinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add("海苔");
//        linkedList.add("傻吊");
//
////        System.out.println(linkedList.size());
//
//        for (int i = 0;i<linkedList.size();i++){
//            System.out.println(linkedList.get(i).toString());
//        }

//        LinkedList<Object> list = new LinkedList<>();

        DoublyLinkedList<Object> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add("aa");
        list.add("aaa");
        list.add("b");
        list.add(2, "add");
        list.remove(3);
//        list.print();
//        System.out.println(list.get(4).toString());
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }

}
