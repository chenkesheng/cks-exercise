package com.cks.exercise;

/**
 * @Author: cks
 * @Date: Created by 10:01 2018/8/31
 * @Package: com.cks.exercise
 * @Description:
 */
public class LinkList<T> {

    private Node head;
    private Node tail;

    private int size = 0;

    private class Node {
        private Object data;
        private Node next;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    //尾插法
    public void add(Object obj) {
        Node newNode = new Node(obj);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        if (tail != null) {
            tail.next = newNode;
            tail = tail.next;
        }
//        Node temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = newNode;
        size++;
    }

    public void add(int index, Object obj) throws Exception {
        Node newNode = new Node(obj);
        //判断要插入的位置是否合法
        if (index < 1 || index > size + 1) {
            throw new Exception("插入位置不合法");
        }
        //记录遍历到第几个节点
        int length = 1;
        //移动的指针
        Node temp = head;
        //遍历链表
        while (temp.next != null) {
            if (index == length++) {
                //temp代表当前的前一个节点
                //temp  当前位置  后一个节点
                //temp  temp.next temp.next.next
                //插入操作
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
//            temp = temp.next;
        }
    }

//    public void add(int index, Object obj) {
//        if (index < 1 || index > size + 1) {
//            System.err.println("删除位置不合法");
//        }
//        Node node = new Node(obj);
//        Node temp = head;
//        int length = 1;
//        while (temp.next != null) {
//            if (index == length++) {
//                node.next = temp.next;
//                temp.next = node;
//                return;
//            }
// //        temp = temp.next;
//        }
//    }

    public void remove(int index) {
        Node temp = head;
        int length = 1;
        if (index < 1 || index > size) {
            System.err.println("删除位置不合法");
        }
        while (temp.next != null) {
            if (index == length++) {
                temp.next = temp.next.next;
                break;
            }
        }
//        temp = temp.next;
    }

    public LinkList() {
    }


    //还可以每次遍历链表的长度来进行技术size;
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void printAll() {
        if (head != null) {
            System.out.print(head.data + " ");
            printNodeData(head.next);
        }
    }

    /**
     * 通过递归从尾到头输出单链表
     *
     * @param head
     */
    public void printNodeData(Node head) {
        if (head != null) {
            System.out.print(head.data + " ");
            printNodeData(head.next);
        }
    }
}
