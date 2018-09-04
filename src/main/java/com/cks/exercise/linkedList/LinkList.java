package com.cks.exercise.linkedList;

/**
 * @Author: cks
 * @Date: Created by 10:01 2018/8/31
 * @Package: com.cks.exercise
 * @Description:
 */
public class LinkList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size = 0;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node() {
        }

        public Node(T data) {
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

    //尾插法
    public void add(T obj) {
        Node<T> newNode = new Node<>(obj);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
//        if (tail != null) {
//            tail.next = newNode;
//            tail = tail.next;
//        }
        //头插法
        newNode.next = head;
        head = newNode;
//        Node temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = newNode;
        size++;
    }

    public void add(int index, T obj) throws Exception {
        Node<T> newNode = new Node<>(obj);
        //判断要插入的位置是否合法
        if (index < 1 || index > size + 1) {
            throw new Exception("插入位置不合法");
        }
        //记录遍历到第几个节点
        int length = 1;
        //移动的指针
        Node<T> temp = head;
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

    public void remove(int index) throws Exception {
        Node<T> temp = head;
        int length = 1;
        if (index < 1 || index > size) {
            throw new Exception("删除位置不合法");
        }
        while (temp.next != null) {
            if (index == 1) {
                head = temp.next;
                return;
            }
            if (index == length++) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }


    public void reverseBetween(int m, int n) {
        Node<T> temp = head;
        Node<T> p = head;
        int length = 1;

        Node<T> first = head;
        Node<T> last = head;

        for (int j = m; j <= n; j++) {
            temp = temp.next;
        }
//        for (int i = 0; i < m; i++) {
//            last = last.next;
//        }

        if (m == 1) {
            head = temp.next;
            return;
        }

        while (p.next != null) {
            if (m == length++) {
                temp.next = p.next.next;
                p.next = temp;
//                p.next = temp;
                return;
            }
//            p = p.next;
        }


//        while (first.next != null) {
//            if (n == length++) {
//                last.next = first.next.next;
//                first.next = last;
//                return;
//            }
////            first = first.next;
//        }
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
    public void printNodeData(Node<T> head) {
        if (head != null) {
            System.out.print(head.data + " ");
            printNodeData(head.next);
        }
    }

    public void dup() {
        if (head != null) {
            deleteDuplication(head);
        }
    }

    public void deleteDuplication(Node<T> pHead) {
        Node<T> p = pHead;
        while (p != null) {
            T data = p.data;
            Node<T> pre = p;
            Node<T> h = p.next;
            while (h != null) {
                if (h.data.equals(data)) {
                    pre.next = h.next;
                    h.next = null;
                    h = pre.next;
                    size--;
                } else {
                    pre = h;
                    h = h.next;
                }
            }
            p = p.next;
        }
    }

//    public void deleteDuplication(Node<T> pHead) {
//        Node<T> p = pHead;
//        while (p != null) {
//            T data = p.data;
//            Node<T> last = p.next;
//            Node<T> pre = p;
//            while (data.equals(last.data)){
//                pre.next = last.next;
//            }
//            p = p.next;
//        }
//    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        Node<T> p = head;
        int length = 0;
        while (length != index && p != tail) {
            length++;
            p = p.next;
        }
        return p.data;
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
