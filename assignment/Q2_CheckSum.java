package assignment;

import java.util.Scanner;

public class Q2_CheckSum {

    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a 9 digit number: ");
        String number = sc.nextLine();
        sc.close();

        int checksum = 0, digit = 10;

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            int z = Integer.parseInt("" + ch);
            checksum += digit * z;
            digit--;
        }

        int mul = (checksum / 11) + 1;
        int d1 = mul * 11 - checksum;

        // Output
        if (d1 > 10) {
            System.out.println("Invalid ISBN Number");
        } else {
            String isbnStr = "" + (d1 == 10 ? "X" : d1);
            String isbn = number.charAt(0) + "-" + number.substring(1, 4) + "-" + number.substring(4) + "-" + isbnStr;
            System.out.println(isbn);
        }
    }
}