package assignment5;

public class Q1_MinTemplate {

    static class MinTemplate<T extends Comparable<T>> {
        T getMin(T a, T b) {
            return a.compareTo(b) < 0 ? a : b;
        }
    }

    public static void main(String[] args) {
        MinTemplate<String> strMin = new MinTemplate<>();
        MinTemplate<Integer> intMin = new MinTemplate<>();

        System.out.println("Smaller in ABC and ABD is: ");
        System.out.println(strMin.getMin("ABC", "ABD"));

        System.out.println("Smaller in 5 and 1 is: ");
        System.out.println(intMin.getMin(5, 1));
    }

}