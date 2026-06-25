package com.cks.exercise.algorithm;

public class 两个链表并集和交集 {


    // head of list
   public static Node head;

    // Linked list Node
   static class Node<T> {
        int data;
        Node<T> next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to get Union of 2
       Linked Lists */
   static void getUnion(Node head1,
                  Node head2) {
        Node t1 = head1, t2 = head2;

        // Insert all elements of list1
        // in the result
        while (t1 != null) {
            push(t1.data);
            t1 = t1.next;
        }

        // Insert those elements of list2
        // that are not present
        while (t2 != null) {
            if (!isPresent(head, t2.data))
                push(t2.data);
            t2 = t2.next;
        }
    }

   static void getIntersection(Node head1,
                         Node head2) {
        Node result = null;
        Node t2 = head1;

        // Traverse list1 and search each
        // element of it in list2.
        // If the element is present in
        // list 2, then insert the
        // element to result
        while (t2 != null) {
            if (isPresent(head2, t2.data)){
                push(t2.data);
            }
            t2 = t2.next;
        }
    }

    // Utility function to print list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /*  Inserts a node at start of
        linked list */
   static void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3\. Make next of new Node as head */
        new_node.next = head;

        /* 4\. Move the head to point to
              new Node */
        head = new_node;
    }


    /* A utility function that returns true
       if data is present in linked list
       else return false */
   static boolean isPresent(Node head, int data) {
        Node t = head;
        while (t != null) {
            if (t.data == data){
                return true;
            }
            t = t.next;
        }
        return false;
    }

    // Driver code
    public static void main(String args[]) {
        两个链表并集和交集 llist1 = new 两个链表并集和交集();
        两个链表并集和交集 llist2 = new 两个链表并集和交集();
        两个链表并集和交集 unin = new 两个链表并集和交集();
        两个链表并集和交集 intersecn = new 两个链表并集和交集();

        for (int i : new int[]{0, 1}) {
            
        }



        /* Create a linked lits 10->15->5->20 */
        llist1.push(20);
        llist1.push(4);
        llist1.push(15);
        llist1.push(10);

        llist1.printList();

        /* Create a linked lits 8->4->2->10 */
        llist2.push(10);
        llist2.push(2);
        llist2.push(4);
        llist2.push(8);

        llist2.printList();

//        intersecn.getIntersection(llist1.head,
//                llist2.head);
//        unin.getUnion(llist1.head, llist2.head);

//        System.out.println("First List is");
//        llist1.printList();
//
//        System.out.println("Second List is");
//        llist2.printList();

//        System.out.println("Intersection List is");
//        intersecn.printList();

//        System.out.println("Union List is");
//        unin.printList();
    }
}