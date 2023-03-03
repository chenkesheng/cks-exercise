package com.cks.exercise;

import com.cks.exercise.collections.CksList;
import com.cks.exercise.linkedList.CycleLinkedList;
import com.cks.exercise.linkedList.DoublyLinkedList;
import com.cks.exercise.linkedList.LinkList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: cks
 * @Date: Created by 15:22 2018/8/29
 * @Package: com.cks.exercise
 * @Description:
 */
public class Test {

    /**
     * 私有成员变量
     */
    private static volatile Test instance;

    /**
     * 私有构造方法
     */
    private Test() {
    }

    /**
     * 提供公共的访问方法
     *
     * @return
     */
    public static Test init() {
        if (instance == null) {
            synchronized (Test.class) {
                if (instance == null) {
                    instance = new Test();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {

        String a = "salePrice=(orderFlag==1?inSalePrice:salePrice)";
        String b = "(orderFlag==1?inSalePrice:salePrice)=(orderFlag==1?inSalePrice:salePrice)";
        String c = "unitQty=unitQty";
        UserTest userTest = new UserTest();
        List<String> userName = Lists.newArrayList();
        UserEntity userEntity = new UserEntity();
        userTest.setUserEntity(userEntity);
        userEntity.setName(userName);
        userName.add(a);
        userName.add(b);
        userName.add(c);
        userEntity.setAge(18);

        System.out.println(userTest.getUserEntity().getAge());
        System.out.println(userTest.getUserEntity().getName().toString());


        String[] result = {"a", "b", "c", "d"};
        System.out.println(result.length);


//        List<String> a  = new LinkedList<>();
//
//        CksList<Integer> test = new CksList<>();
//        test.add(2);
//        test.add(3);
//        test.add(1);
//        test.add(5);
//
//        test.remove(1);
//
//        for(int i = 0;i<test.size();i++){
//            System.out.println(test.get(i).toString());
//        }

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);

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

//        DoublyLinkedList<Object> list = new DoublyLinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add("aa");
//        list.add("aaa");
//        list.add("b");
//        list.add(2, "add");
//        list.remove(3);
//        list.print();
//        System.out.println(list.get(4).toString());
//        for(int i = 0;i<list.size();i++){
//            System.out.println(list.get(i).toString());
//        }
    }

}
