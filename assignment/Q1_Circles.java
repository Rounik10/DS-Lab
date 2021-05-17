package assignment;

import java.util.Scanner;
import java.util.ArrayList;

class Circle {
    Point centre;
    double radius;

    Circle(int x, int y, int r) {
        centre = new Point(x, y);
        this.radius = r;
    }

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    void display() {
        System.out.println("Centre Co-ordinates:" + centre);
        System.out.println("Radius: " + radius);
    }
}

class Line {
    double m, c;
    double x1, x2, y1, y2;

    Line(Point A, Point B) {
        this.x1 = A.x;
        this.y1 = A.y;
        this.x2 = B.x;
        this.y2 = B.y;
        this.m = getSlope();
        this.c = y1 - m * x1;
    }

    double getSlope() {
        return (y2 - y1) / (x2 - x1);
    }

    double getY(double x) {
        return m * x + c;
    }

}

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Q1_Circles {

    static Scanner sc;

    static Circle getCircle() {
        System.out.println("Enter the x-coordinate: ");
        int x = sc.nextInt();

        System.out.println("Enter the y-coordinate: ");
        int y = sc.nextInt();

        System.out.println("Enter the radius: ");
        int r = sc.nextInt();
        return new Circle(x, y, r);
    }

    static ArrayList<Point> getIntersection(Circle circle, Line line) {
        double m = line.getSlope(), c = line.c, p = circle.centre.x, q = circle.centre.y, r = circle.radius;
        double A, B, C, rootD;
        A = 1 + m * m;
        B = 2 * (m * c - m * q - p);
        C = (q * q - r * r + p * p - 2 * c * q + c * c);
        rootD = Math.sqrt(B * B - 4 * A * C);

        ArrayList<Point> interPoints = new ArrayList<>(4);

        double x1 = (-B + rootD) / 2 * A;
        double y1 = line.getY(x1);
        interPoints.add(new Point(x1, y1));

        double x2 = (-B - rootD) / 2 * A;
        double y2 = line.getY(x2);
        interPoints.add(new Point(x2, y2));

        return interPoints;
    }

    static double getDistance(Point A, Point B) {
        double dx = A.x - B.x;
        double dy = A.y - B.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static Point getMidPoint(Point A, Point B) {
        return new Point((A.x + B.x) / 2, (A.y + B.y) / 2);
    }

    static Circle getEncCircle(Circle first, Circle second) {

        Line midLine = new Line(first.centre, second.centre);

        Point midPoint = getMidPoint(first.centre, second.centre);

        Point leftMost = getMaxDistPt(midPoint, getIntersection(first, midLine));

        Point rightMost = getMaxDistPt(midPoint, getIntersection(second, midLine));

        Point centre = getMidPoint(leftMost, rightMost);
        double radius = getDistance(centre, leftMost);

        return new Circle(centre, radius);
    }

    static Point getMaxDistPt(Point midPoint, ArrayList<Point> pointList) {
        Point maxDist = null;
        double max = -1;
        for (Point curPoint : pointList) {
            double dist = getDistance(curPoint, midPoint);
            if (dist > max) {
                maxDist = curPoint;
                max = dist;
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("For first circle:");
        Circle first = getCircle();
        System.out.println("For second circle:");
        Circle second = getCircle();

        Circle enc = getEncCircle(first, second);
        enc.display();
    }

}