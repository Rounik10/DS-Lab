package assignment3;

import java.util.Scanner;

public class Q1_ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head, tail;

    static Node reveseList(Node head) {
        Node cur = head, prev = null, next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    static void addNode(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    static void printList(Node headNode) {
        Node temp = headNode;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Now enter " + n + " nodes: ");
        for (int i = 0; i < n; i++) {
            addNode(sc.nextInt());
        }
        sc.close();

        System.out.println("Current List: ");
        printList(head);

        Node rev = reveseList(head);
        System.out.println("Reversed List: ");
        printList(rev);
    }

}