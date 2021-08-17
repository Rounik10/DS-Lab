package assignment3;

/*
    Write an algorithm that will split a linked list into two linked lists, so
    that successive nodes go to different lists.
    i.e. the first, third, and all odd numbered nodes to the first list, 
    and the second, fourth, and all even numbered nodes go to the second.
*/

import java.util.Scanner;

public class Q2_SplitList {
    static Node head, tail;
    static Node even, odd;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
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

    static Node[] splitList(Node head) {
        Node[] split = new Node[2];
        if (head == null)
            return split;

        Node odd = head, even = head.next;
        Node oItr = odd, eItr = even;

        while (oItr.next != null && eItr.next != null) {
            oItr.next = oItr.next.next;
            oItr = oItr.next;

            eItr.next = eItr.next.next;
            eItr = eItr.next;
        }

        split[0] = odd;
        split[1] = even;

        return split;
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
        System.out.println("Complete List: ");
        printList(head);

        Node[] split = splitList(head);

        System.out.println("Odd List: ");
        printList(split[0]);

        System.out.println("Even List: ");
        printList(split[1]);
    }

}