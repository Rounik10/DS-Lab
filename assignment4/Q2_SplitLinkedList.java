package assignment4;

import java.util.Scanner;

/**
 * 
 * Write a function that will concatenate two circularly linked lists,producing
 * one circularly linked list.
 * 
 * Write a function that will split a circularly linked list, into two
 * circularly linked lists.
 * 
 * Write a function for manipulating a doubly linked list as follows: a. add a
 * node after p. b. Add a node before p. c. Delete node p. d. traverse the list.
 * 
 * Write and test a recursive function
 * 
 */

public class Q2_SplitLinkedList {

    static void splitList(MyCircularLinkedList list, int index) {

        Node newHead = list.head, newTail = newHead;

        for (int i = 0; i < index; i++) {
            newHead = newHead.next;
            if (i > 0)
                newTail = newTail.next;
        }

        Node tail = list.tail;

        list.tail.next = newHead;
        list.tail = newTail;
        newTail.next = list.head;

        MyCircularLinkedList second = new MyCircularLinkedList();
        second.head = newHead;
        second.tail = tail;

        System.out.println("First List: ");
        list.display();

        System.out.println("Second List: ");
        second.display();

    }

    public static void main(String[] args) {

        MyCircularLinkedList clist = new MyCircularLinkedList();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Now enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            clist.insert(sc.nextInt());
        }
        System.out.println("Current List: ");
        clist.display();

        System.out.println("Enter the index for spliting: ");
        int index = sc.nextInt();
        sc.close();
        splitList(clist, index);
    }

}
