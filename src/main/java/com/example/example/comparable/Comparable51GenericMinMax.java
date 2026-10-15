package com.example.comparable;

public class Comparable51GenericMinMax {
    static <T extends Comparable<? super T>> T min(T a, T b) {
        return a.compareTo(b) <= 0 ? a : b;
    }
    static <T extends Comparable<? super T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static void main(String[] x) {
        System.out.println(min("pear", "plum"));
        System.out.println(max(12, 7));
        // Generic bounds let compareTo choose the natural order.
    }
}
