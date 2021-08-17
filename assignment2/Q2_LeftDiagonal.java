package assignment2;

import java.util.Scanner;

public class Q2_LeftDiagonal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N: ");
        int n = sc.nextInt();
        int[][] A = new int[n][n];

        System.out.println("Enter " + n * n + " elements in the matrix: ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
                if (i == j) {
                    sum += A[i][j];
                }
            }
        }
        System.out.println("Sum of left diagonal elements: " + sum);
        sc.close();
    }

}