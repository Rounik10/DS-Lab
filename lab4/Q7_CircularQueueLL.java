package lab4;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularQueue {
    private Node tail;

    void addNode(int value) {
        Node toAdd = new Node(value);
        if (tail == null) {
            tail = toAdd;
            tail.next = tail;
        } else {
            toAdd.next = tail.next;
            tail.next = toAdd;
            tail = tail.next;
        }
    }

    int deleteNode() {
        if (tail == null) {
            System.err.println("Queue is empty");
        }
        Node toDelete = tail.next;
        if (toDelete == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        return toDelete.data;
    }

    void display() {
        Node temp = tail.next;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != tail);
    }
}

public class Q7_CircularQueueLL {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        for (int i = 10; i <= 50; i += 10)
            queue.addNode(i);
        queue.display();
    }
}