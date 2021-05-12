package lab3;

/* Write a function that will read one line of input from the terminal. 
    The input is supposed to consist of two parts separated by a colon’:’. 
    As its result your function should produce a single character as follows:
    N No Colon on the Line.
    L The Left part (before the colon) is longer then the right
    R The Right part (after the colon) is longer then the left. 
    D The left and right parts have same length but are different.
    S The Left and Right parts are exactly the same.
    Use a queue to keep track of the left part of the line while reading the right part.
*/

import java.util.Scanner;

public class Q6_ColonChar {

    static char getCharecter(String input) {

        int length = input.length();
        int colonIndex = -1;
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == ':') {
                colonIndex = i;
                break;
            }
        }

        if (colonIndex == -1) {
            return 'N';
        } else if (colonIndex > length - 1 - colonIndex) {
            return 'L';
        } else if (colonIndex < length - 1 - colonIndex) {
            return 'R';
        } else {
            for (int i = 0, j = colonIndex + 1; i < colonIndex; i++, j++) {
                if (input.charAt(i) != input.charAt(j)) {
                    return 'D';
                }
            }
            return 'S';
        }
    }

    public static void main(String[] args) {
        // Taking User Input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string: ");
        String input = sc.nextLine();
        sc.close();

        // Output
        char ans = getCharecter(input);
        System.out.println("Respective Character: " + ans);

    }

}