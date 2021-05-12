package lab1;

/*
 
 Let stack_ptr be a pointer to stack of integers and item be an integer variable. 
 Write function like Push, Pop, Initialize, Empty, and Full for doing the following tasks. 
 [You may declare additional variable in your functions in needed]

	a. Return the top element of the stack and leave the top element unchanged. If the stack is empty, return INT_MAX.
	b. Return the third element from the top of the stack, provided that the stack contains at least three integers. If not, return INT_MAX. Leave the stack unchanged.
	c. Returns the bottom element of stack ( or INT_MAX if stack empty), and leave the stack unchanged.
	d. Delete all occurrences of x from the stack, leaving the other
	elements of the stack in the same order.

*/

public class Q1_Stack {

    public static void main(String[] args) {

        MyStack st = new MyStack(5);

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(2);
        st.push(1);

        // Current Stack {1, 2, 3, 2, 1}
        System.out.print("Current Stack: ");
        st.display();

        // a) Top of stack, unchanged.
        int top = st.top();
        System.out.println("\nTop element: " + top);

        // b) 3rd (i'th) element from the top.
        int thirdFromTop = st.getIthFromTop(3);
        System.out.println("\nThird form top: " + thirdFromTop);

        // c) Bottom element of the stack.
        int bottom = st.getBottom();
        System.out.println("\nBottom element: " + bottom);

        // d) Delete all occurrences of x from the stack.
        st.deleteAllOcc(2);
        System.out.println("\nAfter deleing occurrences of 2");
        st.display();

    }
}