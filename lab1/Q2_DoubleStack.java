package lab1;

class DoubleStack {
    private int[] dualStack;
    private int topA, topB;

    DoubleStack(int size) {
        dualStack = new int[size];
        topA = -1;
        topB = size;
    }

    void pushA(int val) {
        if (isFull()) {
            System.err.println("Stack A is full");
        } else {
            dualStack[++topA] = val;
        }
    }

    int popA() {
        int top = topA();
        topA--;
        return top;
    }

    int topA() {
        if (isEmpty('A')) {
            System.err.println("Stack A is empty");
            return -1;
        }
        return dualStack[topA];
    }

    void pushB(int val) {
        if (isFull()) {
            System.err.println("Stack B is full");
        } else {
            dualStack[--topB] = val;
        }
    }

    int popB() {
        int top = topB();
        topB++;
        return top;
    }

    int topB() {
        if (isEmpty('B')) {
            System.err.println("Stack B is empty");
            return -1;
        }
        return dualStack[topB];
    }

    boolean isEmpty(char stack) {
        if (stack == 'A')
            return topA == -1;
        else
            return topB == dualStack.length;
    }

    boolean isFull() {
        return topA + 1 == topB;
    }

    void displayA() {
        if (isEmpty('A')) {
            System.out.println("Stack A is EMPTY");
            return;
        }
        System.out.print("{");
        for (int i = 0; i < topA; i++) {
            System.out.print(dualStack[i] + ", ");
        }
        System.out.println(topA() + "} <--TOP");
    }

    void displayB() {
        if (isEmpty('B')) {
            System.out.println("Stack B is EMPTY");
            return;
        }
        System.out.print("{");
        for (int i = dualStack.length - 1; i > topB; i--) {
            System.out.print(dualStack[i] + ", ");
        }
        System.out.println(topB() + "} <--TOP");
    }

    void displayDualStack() {
        System.out.print("{");
        for (int i = 0; i < dualStack.length - 1; i++) {
            System.out.print(dualStack[i] + ", ");
        }
        System.out.println(dualStack[dualStack.length - 1] + "}");
    }

}

public class Q2_DoubleStack {

    public static void main(String[] args) {

        DoubleStack dst = new DoubleStack(10);

        dst.pushA(10);
        dst.pushA(8);
        dst.pushA(6);

        dst.pushB(3);
        dst.pushB(2);
        dst.pushB(1);

        System.out.println("Dual Stack:");
        dst.displayDualStack();

        System.out.println("\nStack A: ");
        dst.displayA();

        System.out.println("\nStack B: ");
        dst.displayB();
    }

}