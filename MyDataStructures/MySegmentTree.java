package MyDataStructures;

import java.util.Scanner;

public class MySegmentTree {

    final static int N = (int) 10e5;
    static int[] arr = new int[N];
    static int[] tree = new int[4 * N];

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();

        build(1, 0, n - 1);
        for (int i = 1; i < 15; i++) {
            System.out.println(tree[i]);
        }
    }

}