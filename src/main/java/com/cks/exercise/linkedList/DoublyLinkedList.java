package com.cks.exercise.linkedList;

/**
 * @Author: cks
 * @Date: Created by 9:53 2018/9/4
 * @Package: com.cks.exercise.linkedList
 * @Description:
 */
public class DoublyLinkedList<E> {

    //内部节点类
    private class Node<E> {
        Node<E> pre;
        Node<E> next;
        E item;

        Node(Node<E> pre, E item, Node<E> next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    //链表的属性 大小 头节点 尾节点
    private int size = 0;

    private Node<E> header;

    private Node<E> tail;

    //初始化链表
    public DoublyLinkedList() {
//        this.size = 0;
//        header = new Node<>(null, null, null);
//        tail = new Node<>(header, null, null);
//        header.next = tail;
//        if (header == null) {
//            System.err.println("header is null");
//        }
//        if (tail == null) {
//            System.err.println("tail is null");
//        }
    }


    //添加元素
    public void add(E item) {
//        Node<E> newNode = new Node<>(item, null, null);
//        tail.pre.next = newNode;
//        newNode.pre = tail.pre;
//        newNode.next = tail;
//        tail.pre = newNode;
//        size++;
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(l, item, null);
        tail = newNode;
        if (l == null)
            header = newNode;
        else
            l.next = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //获取某个节点
    public E get(int index) {
//        if (idx >= size || idx < 0) {
//            throw new IndexOutOfBoundsException();
//        }
//        Node<E> current = header.next;
//        int length = 0;
//        while (length != idx && current != tail) {
//            length++;
//            current = current.next;
//        }
//        return current.item;
//        for(int i=0; i<=idx; i++){
//            current = current.next;
//        }
//        return current.item;
        return node(index).item;
    }


    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = header;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.pre;
            return x;
        }
    }


    //输出链表
    public void print() {
        Node<E> current = header.next;
        while (current != null) {
            System.out.println(current.item.toString());
            current = current.next;
        }
    }
}
