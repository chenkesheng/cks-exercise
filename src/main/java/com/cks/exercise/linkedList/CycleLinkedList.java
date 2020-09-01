package com.cks.exercise.linkedList;

/**
 * @Author: cks
 * @Date: Created by 8:51 2018/9/3
 * @Package: com.cks.exercise.linkedList
 * @Description: 循环链表->头插法
 */
public class CycleLinkedList<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private Node<E> p;

    private int size = 0;

    /**
     * 获取链表长度
     *
     * @return 返回大小
     */
    public int size() {
        return size;
    }

    /**
     * 新增数据
     *
     * @param obj 入参
     */
    public void add(E obj) {
        Node<E> newNode = new Node<>(obj);
        if (head == null) {
            head = newNode;
            tail = head;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
        p = head;
        size++;
    }

    /**
     * 获取元素
     *
     * @param index 索引
     * @return 返回值
     */
    public E get(int index) {
        int length = 0;
        p = head;
        while (length != index && p != tail) {
            length++;
            p = p.next;
        }
        return p.data;
    }
}
