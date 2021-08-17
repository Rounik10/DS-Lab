package assignment5;

class Media {
    String title;
    double price;

    Media(String title, double price) {
        this.title = title;
        this.price = price;
    }

    void displayData() {
        System.out.println("Title: " + title);
        System.out.println("Price: Rs " + price);
    }
}

class Book extends Media {

    private int pages;

    Book(String title, double price, int pages) {
        super(title, price);
        this.pages = pages;
    }

    @Override
    void displayData() {
        System.out.println("\nBook Details:");
        super.displayData();
        System.out.println("Pages: " + pages);
    }

}

class Tape extends Media {
    private int length;

    Tape(String title, double price, int length) {
        super(title, price);
        this.length = length;
    }

    @Override
    void displayData() {
        System.out.println("\nTape Details:");
        super.displayData();
        System.out.println("Length: " + length);
    }
}

public class Q6_MediaTest {
    public static void main(String[] args) {
        Book book = new Book("The Book", 590, 1000);
        book.displayData();
        Tape tape = new Tape("The Tape", 180, 12);
        tape.displayData();
    }
}
