package assignment2;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    void add(int data) {
        Node toAdd = new Node(data);
        if (head == null) {
            head = toAdd;
            tail = head;
        } else {
            tail.next = toAdd;
            toAdd.prev = tail;
            tail = tail.next;
        }
    }

    void deleteHead() {
        if (tail.prev == null) {
            head = tail = null;
        }
        head.next.prev = null;
        head = head.next;
    }
}

public class Q1_Pattern {

    static void printList(LinkedList list) {
        Node temp = list.head;

        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.print(temp.data + " ");

        while (temp != list.head) {
            temp = temp.prev;
            System.out.print(temp.data + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int n = sc.nextInt();
        sc.close();

        LinkedList list = new LinkedList();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("  ");
            }
            if (list.tail == null) {
                list.add(1);
            } else {
                for (int j = list.tail.data + 1; j <= 2 * i - 1; j++) {
                    list.add(j);
                }
            }
            printList(list);
            list.deleteHead();
        }
    }
}