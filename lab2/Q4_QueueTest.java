package lab2;

/*
    Implement queues by the simple method of keeping the head of the queue always
    in the first position of a linear array.
*/

public class Q4_QueueTest {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue(5);

        for (int i = 1; i <= 10; i += 2) {
            queue.enque(i);
        }

        System.out.println("Current queue: ");
        queue.display();

        System.out.println("Dequed Element: " + queue.deque());
        System.out.println("Updated Queue:");
        queue.display();

    }

}