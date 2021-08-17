package assignment7;

import java.util.Scanner;

public class ContainmentZone {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point east, west, north, south;

    static void updatePoints(Point curr) {
        if (east.x > curr.x) {
            east = curr;
        }
        if (west.x < curr.x) {
            west = curr;
        }
        if (north.y < curr.x) {
            north = curr;
        }
        if (south.y > curr.x) {
            south = curr;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of COVID Positive patents: ");
        int noPos = sc.nextInt();

        Point[] positives = new Point[noPos];
        int xMax = 0, yMax = 0;
        east = west = north = south = new Point(0, 0);

        for (int i = 0; i < noPos; i++) {
            positives[i] = new Point(sc.nextInt(), sc.nextInt());
            xMax = Math.max(xMax, positives[i].x);
            yMax = Math.max(yMax, positives[i].y);

            if (i == 0)
                east = west = north = south = positives[0];
            else
                updatePoints(positives[i]);
        }

        System.out.println("Enter number of COVID Negative patents: ");
        int noNeg = sc.nextInt();

        Point[] negetives = new Point[noNeg];
        for (int i = 0; i < noNeg; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            negetives[i] = new Point(y, x);
            xMax = Math.max(xMax, negetives[i].x);
            yMax = Math.max(yMax, negetives[i].y);
        }
        sc.close();

        String[][] matrix = new String[xMax + 1][yMax + 1];

        for (int i = 0; i < xMax + 1; i++) {
            for (int j = 0; j < yMax + 1; j++) {
                matrix[i][j] = "   ";
            }
        }

        for (Point pt : positives) {
            matrix[pt.x][pt.y] = "(+)";
        }

        for (Point ng : negetives) {
            matrix[ng.x][ng.y] = "(-)";
        }

        // Rectangle:
        for (int j = east.x + 1; j < west.x; j++) {
            matrix[north.y][j] = "---";
            matrix[south.y][j] = "---";
        }
        int left = Math.min(north.x, south.x);
        int right = Math.max(north.y, south.y);
        for (int i = left + 1; i < right; i++) {
            matrix[i][left] = " | ";
            matrix[i][right] = " | ";
        }

        System.out.println("\n Containment Zone: \n");

        for (int i = yMax; i >= 0; i--) {
            // Y-axis
            System.out.print(i + "|");

            // X-axis
            if (i == 0) {
                for (int j = 0; j < xMax; j++) {
                    System.out.print("-+-");
                }
                System.out.println();
                System.out.print(" ");
                for (int j = 1; j <= xMax; j++) {
                    System.out.print("  " + j);
                }
            }

            // value
            for (int j = 1; j <= xMax; j++) {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }
    }
}