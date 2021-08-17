package assignment2;

import java.util.Scanner;

public class Q5_RightDiagMat {

    static void printUpperDiag(int[][] A, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    System.out.print(A[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = sc.nextInt();
        int[][] A = new int[n][n];

        System.out.println("Enter " + n * n + " elements for matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println("Upper Diagonal Matrix");
        printUpperDiag(A, n);
    }

}
