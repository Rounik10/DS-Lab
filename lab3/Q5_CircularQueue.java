package lab3;

public class Q5_CircularQueue {

    public static void main(String[] args) {

        final int SIZE = 10;
        MyCircularQueue q = new MyCircularQueue(SIZE);
        System.out.println("Enquing the intilized queue:");

        for (int i = 1; i < 8; i++) {
            q.enque(i);
            q.display();
        }

        System.out.println("\nDequeing elements from the quque:");

        for (int i = 1; i < 4; i++) {
            System.out.println("Dequed: " + q.deque());
        }

        System.out.println("\nUpdated Queue: ");
        q.display();

    }

}