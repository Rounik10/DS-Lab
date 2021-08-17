package assignment5;

import java.util.Scanner;

class Date {
    private int dd, mm, yy;

    public void Set(int d, int m, int y) {
        if (d > 31 || m > 12 || d < 0 || m < 0 || y < 0)
            System.err.println("Invalid date");
        else {
            this.dd = d;
            this.mm = m;
            this.yy = y;
        }
    }

    int checkMonth() {
        if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12)
            return 1;
        else
            return 0;
    }

    public void Increment() {
        dd = dd + 1;
        if (dd > 31 && checkMonth() == 1) {
            dd = 1;
            mm = mm + 1;
            if (mm > 12) {
                mm = 1;
                yy++;
            }
        } else if (dd > 30 && checkMonth() == 0) {
            dd = 1;
            mm = mm + 1;
            if (mm > 12) {
                mm = 1;
                yy++;
            }
        }

    }

    public void Display() {
        System.out.println(dd + "/" + mm + "/" + yy);
    }
}

public class Q4_DateTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Day Month and Year in numbers: ");
        int dd = sc.nextInt(), mm = sc.nextInt(), yyyy = sc.nextInt();
        sc.close();

        Date date = new Date();
        date.Set(dd, mm, yyyy);

        System.out.println("Current Date: ");
        date.Display();

        System.out.println("Date after incrementation");
        date.Increment();
        date.Display();
    }
}