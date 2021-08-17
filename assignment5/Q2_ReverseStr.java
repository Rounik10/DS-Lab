package assignment5;

public class Q2_ReverseStr {

    static class CharStack {
        private char[] stack;
        private int top = -1;

        CharStack(int n) {
            stack = new char[n];
        }

        void push(char data) {
            stack[++top] = data;
        }

        char pop() {
            return stack[top--];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    static String reverse(String s) {
        StringBuilder str = new StringBuilder();
        CharStack st = new CharStack(s.length());
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        while (!st.isEmpty()) {
            str.append(st.pop());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "dlroW olleH";
        String reverse = reverse(s);
        System.out.println("Original: " + s);
        System.out.println("Reversed: " + reverse);
    }

}
