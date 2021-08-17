package assignment5;

/**
 * Write a class called Clock that simulates the keeping of time. Use three
 * private class members: hours, minutes, and seconds. Your class should be able
 * to : Set() that starting time. Increment() the time by one second. Display()
 * the time. The function should take an argument with a default value of zero
 * to imply military time. If this value is something other than zero, display
 * the time in standard Am and PM notation. For example, 4 minutes and 31
 * seconds past 7 PM should be displayed either 19:04:31 or 7:04:31 PM and 5
 * minutes past midnight should be displayed as either 00:05:
 */

class Clock {
    private int hour, minutes, seconds;

    public void setTime(int hour, int minutes, int seconds) {
        if (hour >= 24 || minutes >= 60 || seconds >= 60) {
            System.err.println("Invalid Time!");
            System.exit(1);
        }
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void increment() {
        this.seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hour++;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
    }

    public void display() {
        System.out.printf("%02d:%02d:%02d\n", hour, minutes, seconds);
    }
}

public class Q3_TestClock {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.setTime(12, 10, 59);
        System.out.println("Initial Time: ");
        clock.display();
        clock.increment();
        System.out.println("After Increment: ");
        clock.display();
    }
}
