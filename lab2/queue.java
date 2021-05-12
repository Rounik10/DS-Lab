package lab2;

public class queue {
    int max;
    int queue[];
    int rear;
    int front;

    queue() {
        max = 10;
        queue = new int[max];
        rear = 0;
        front = 0;
    }

    void enqueue(int n) {
        if (rear < max) {
            queue[rear] = n;
            System.out.println("Rear = " + rear);
            rear++;
        } else {
            System.out.println("Queue is full");
        }
    }

    int dequeue() {
        int del = 0;
        if (rear != front) {
            del = queue[0];
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            if (rear < max)
                rear--;
        } else {
            System.out.println("Queue is empty");
        }
        return del;
    }

    void display() {
        System.out.println("Queue is being displayed");
        System.out.print("|");
        for (int i = 0; i < rear; i++) {
            System.out.print("   " + queue[i] + "   |");
        }
    }

    public static void main(String[] args) {
        queue ob = new queue();
        ob.enqueue(1);
        ob.enqueue(2);
        ob.enqueue(3);
        ob.enqueue(4);
        ob.display();
        System.out.println("\n\nRemoving element ---> " + ob.dequeue() + "\n");
        ob.display();
        System.out.println("\n\nRemoving element ---> " + ob.dequeue() + "\n");
        ob.display();
    }
}