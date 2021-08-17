package assignment4;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyCircularLinkedList {
    Node head, tail;

    MyCircularLinkedList() {
        this.head = null;
        this.tail = head;
    }

    void insert(int data) {
        Node toAdd = new Node(data);
        if (head == null) {
            head = toAdd;
            tail = head;
        } else {
            tail.next = toAdd;
            tail = tail.next;
            tail.next = head;
        }
    }

    void concatinate(MyCircularLinkedList other) {
        if (other.isEmpty()) {
            return;
        }
        if (this.isEmpty()) {
            this.head = other.head;
            this.tail = other.tail;
        }
        this.tail.next = other.head;
        other.tail.next = this.head;
        this.tail = other.tail;
    }

    void display() {
        Node temp = head;
        while (temp != tail) {
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println(tail.data + " -> Head");
    }

    boolean isEmpty() {
        return head == null;
    }

}

public class Q1_ConcatLinkedList {

    public static void main(String[] args) {
        var clist = new MyCircularLinkedList();
        var second = new MyCircularLinkedList();
        for (int i = 10; i <= 50; i += 10) {
            clist.insert(i);
            second.insert(50 + i);
        }

        System.out.println("First List: ");
        clist.display();
        System.out.println("Second List: ");
        second.display();
        System.out.println("Concatinated List: ");
        clist.concatinate(second);
        clist.display();
    }

}
