package assignment5;

import java.util.Scanner;

public class Q5_CaseChange {

    Scanner sc = new Scanner(System.in);

    String reverseCase(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            builder.append(convert(string.charAt(i)));
        }
        return builder.toString();
    }

    String read() {
        return sc.nextLine();
    }

    void write(String output) {
        System.out.println(output);
    }

    char convert(char c) {
        return (char) ((c >= 'a' && c <= 'z') ? 'A' + (c - 'a') : 'a' + (c - 'A'));
    }

    public static void main(String[] args) {
        Q5_CaseChange caseChange = new Q5_CaseChange();
        System.out.println("Enter the string: ");
        String str = caseChange.read();
        System.out.println("Reversed case string: ");
        caseChange.write(caseChange.reverseCase(str));
    }

}
