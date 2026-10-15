package com.example.comparator;

import java.util.Comparator;

public class Comparator01CompareTwoValues {
    public static void main(String[] args) {
        Comparator<Integer> ascending = Integer::compare;

        // compare(a, b) returns negative, zero, or positive; use the sign, not an assumed magnitude.
        System.out.println("compare(3, 8) sign = "
                + Integer.signum(ascending.compare(3, 8)));
        System.out.println("compare(8, 3) sign = "
                + Integer.signum(ascending.compare(8, 3)));
        System.out.println("compare(5, 5) sign = "
                + Integer.signum(ascending.compare(5, 5)));
    }
}
