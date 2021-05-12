package lab2;

class MyQueue {
    private int[] queue;
    private int head, tail;
    private int size;

    MyQueue(int size) {
        queue = new int[size];
        head = 0;
        tail = head - 1;
        this.size = size;
    }

    void enque(int val) {
        if (!isFull()) {
            queue[++tail] = val;
        } else {
            System.err.println("Queue is full!");
        }
    }

    int front() {
        return queue[head];
    }

    int deque() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");
        }
        int ans = queue[head];
        for (int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }
        tail--;
        return ans;
    }

    boolean isEmpty() {
        return head - 1 == tail;
    }

    boolean isFull() {
        return tail + 1 == size;
    }

    int size() {
        return size;
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