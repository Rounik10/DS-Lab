package assignment4;

import java.util.Scanner;

public class Q4_ArrMin {

    static int getMin(int[] arr, int st, int ind) {
        if (st == ind) {
            return arr[st];
        }
        return Math.min(arr[st], getMin(arr, st + 1, ind));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");

        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Now enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter index till where min will be calulated");
        int ind = sc.nextInt();
        sc.close();

        int min = getMin(arr, 0, ind);
        System.out.println("Min till index " + ind + " is " + min);

    }
}
