package assignment2;

import java.util.Scanner;

public class Q4_LowDiagMat {

    static void printLowerDiag(int[][] A, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
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
        sc.close();

        System.out.println("Lower Diagonal Matrix");
        printLowerDiag(A, n);
    }
}
