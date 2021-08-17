package assignment4;

import java.util.Scanner;

/**
 * Write a function for manipulating a doubly linked list as follows: <br>
 * a. add a node after p. <br>
 * b. Add a node before p. <br>
 * c. Delete node p. <br>
 * d. traverse the list.
 */

class DllNode {
    int data;
    DllNode next;
    DllNode prev;

    DllNode(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

class MyDoublyLinkedList {
    DllNode head, tail;

    MyDoublyLinkedList() {
        head = tail = null;
    }

    void insert(int data) {
        DllNode toAdd = new DllNode(data);
        if (head == null) {
            head = toAdd;
            tail = head;
        } else {
            tail.next = toAdd;
            tail = tail.next;
        }
    }

    void insertAfter(int p, int value) {
        DllNode temp = head;
        while (temp != null && temp.data != p) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("List does not have node with value " + p);
            return;
        }

        DllNode toAdd = new DllNode(value);

        toAdd.next = temp.next;
        toAdd.prev = temp;
        temp.next = toAdd;
    }

    void issertBefore(int p, int value) {
        DllNode temp = head;
        DllNode toAdd = new DllNode(value);
        if (temp.data == p) {
            toAdd.next = temp;
            temp.prev = toAdd;
            head = toAdd;
            return;
        }
        while (temp.next.data != p) {
            temp = temp.next;
        }
        toAdd.next = temp.next;
        toAdd.prev = temp;
        temp.next = toAdd;
    }

    void deleteNode(int value) {
        if (head.data == value) {
            head.next.prev = null;
            head = head.next;
            return;
        }
        DllNode temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        temp.next.prev = null;
        temp.next = temp.next.next;
    }

    /** Traversing the list */
    DllNode getNode(int value) {
        DllNode temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }

    void display() {
        DllNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

}

public class Q3_DoublyLinkedListOp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");

        int n = sc.nextInt();
        System.out.println("Now enter " + n + " elements: ");
        MyDoublyLinkedList list = new MyDoublyLinkedList();

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }
        System.out.println("Current List: ");
        list.display();

        System.out.println("Enter the node value of P");
        int p = sc.nextInt();

        System.out.println("Enter value to be added after P: ");
        int addAfter = sc.nextInt();
        list.insertAfter(p, addAfter);
        System.out.println("After adding " + addAfter + " after P: ");
        list.display();

        System.out.println("Enter value to be added after P: ");
        int addBefore = sc.nextInt();

        list.issertBefore(p, addBefore);
        System.out.println("After adding " + addBefore + " after P: ");
        list.display();

        list.deleteNode(p);
        System.out.println("After deleteing P: ");
        list.display();
        sc.close();
    }

}