package assignment2;

import java.util.Scanner;

public class Q3_RightDiagonal {

    static int getRightDiagonalSum(int[][] A, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    sum += A[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N: ");
        int n = sc.nextInt();
        int[][] A = new int[n][n];

        System.out.println("Enter " + n * n + " elements in the matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int sum = getRightDiagonalSum(A, n);

        System.out.println("Sum of left diagonal elements: " + sum);
        sc.close();
    }
}