package lab1;

public class MyStack {

    private int[] stack;
    private int top;
    private int INT_MAX = Integer.MAX_VALUE;

    // Cosnstrutor to Initialize
    MyStack(int size) {
        if (size < 1) {
            System.err.println("Invalid Size!");
            System.exit(1);
        }
        stack = new int[size];
        top = -1;
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

    // Returns the bottom most elemtnt of the stack.
    int getBottom() {
        if (isEmpty()) {
            System.err.println("Stack is empty!");
            return INT_MAX;
        }
        return stack[0];
    }

    // Checks if the stack is empty.
    boolean isEmpty() {
        return top == -1;
    }

    // Checks if the stack is full.
    boolean isFull() {
        return top == stack.length - 1;
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

    // Get i'th element form the top
    int getIthFromTop(int i) {
        int ind = top - i + 1;
        if (ind < 0) {
            System.err.println("Invalid Index!");
            return INT_MAX;
        }
        return stack[ind];
    }

    // Delete all occurences of the parameter.
    void deleteAllOcc(int toDelete) {
        int k = 0;
        for (int i = 0; i <= top; i++) {
            if (stack[i] == toDelete) {
                k++;
            } else {
                stack[i - k] = stack[i];
            }
        }
        top -= k;
    }
}
