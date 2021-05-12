package lab2;

class MyStack {

    private int[] stack;
    private int top, size;
    private final int INT_MAX = Integer.MAX_VALUE;

    // Cosnstrutor to Initialize
    MyStack(int size) {
        if (size < 1) {
            System.err.println("Invalid Size!");
            System.exit(1);
        }
        stack = new int[size];
        this.size = size;
        top = -1;
    }

    int getSize() {
        return size;
    }

    // Adds the element to the stack.
    void push(int toAdd) {
        if (isFull()) {
            System.err.println("Stack is full!");
        } else {
            stack[++top] = toAdd;
        }
    }

    // Removes the element from the top.
    int pop() {
        int topElement = top();
        top--;
        return topElement;
    }

    // Retruns the topmost element of the stack.
    int top() {
        if (isEmpty()) {
            System.err.println("Stack is empty!");
            return INT_MAX;
        }
        return stack[top];
    }

    // Checks if the stack is empty.
    boolean isEmpty() {
        return top == -1;
    }

    // Checks if the stack is full.
    boolean isFull() {
        return top == size - 1;
    }

    // Prits the elemets of the stack.
    void display() {
        if (isEmpty()) {
            System.out.println("{ EMPTY }");
            return;
        }
        System.out.print("{");
        for (int i = 0; i < top; i++) {
            System.out.print(stack[i] + ", ");
        }
        System.out.println(top() + "}");
    }

    int remainingSpace() {
        return size - top + 1;
    }

}

public class Q3_StackOperations {

    // Use the functions developed to write other functions that will
    // a. Empty one stack onto the top of another stack
    // b. Move all the items from a queue onto a stack.
    // c. Start with a queue and an empty stack, and use the stack to reverse the
    // order of all the items in the queue.

    void addAll(MyStack thisStack, MyStack other) {
        if (thisStack.remainingSpace() < other.getSize()) {
            System.err.println("Stack one doesn't have enough space!");
            return;
        }
        while (!other.isEmpty()) {
            thisStack.push(other.pop());
        }
    }

    MyStack getStackFromQueue(MyQueue queue) {
        MyStack st = new MyStack(queue.size());
        while (!queue.isEmpty()) {
            st.push(queue.deque());
        }
        return st;
    }

    void reverseQueue(MyQueue queue) {
        MyStack st = getStackFromQueue(queue);
        while (!st.isEmpty()) {
            queue.enque(st.pop());
        }
    }

    public static void main(String[] args) {

    }
}