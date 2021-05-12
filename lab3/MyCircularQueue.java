package lab3;

public class MyCircularQueue {

    private int[] queue;
    private int size, head, tail;

    MyCircularQueue(int size) {
        queue = new int[size];
        this.size = size;
        head = 1;
        tail = 0;
    }

    void enque(int val) {
        if (isFull()) {
            System.err.println("Queue is full!");
        } else {
            tail = modIncreamt(tail);
            queue[tail] = val;
        }
    }

    int deque() {
        if (isEmpty()) {
            System.err.println("Queue is Empty!");
            return -1;
        }
        int val = queue[head];
        head = modIncreamt(head);
        return val;
    }

    boolean isFull() {
        return (tail + 2) % size == head;
    }

    boolean isEmpty() {
        return (tail + 1) % size == head;
    }

    private int modIncreamt(int ind) {
        return ind = ind + 1 > size ? 0 : ind + 1;
    }

    void display() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("HEAD -> {");
        int i = head;
        while (i < tail) {
            System.out.print(queue[i] + ", ");
            i++;
        }
        System.out.println(queue[tail] + "} <- TAIL");
    }

}
