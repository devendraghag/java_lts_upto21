package com.example.staticimport;

import static java.lang.Math.*;

/** Demonstrates an on-demand static import using the Math utility class. */
public class StaticImportOnDemandDemo {
    public static void main(String[] args) {
        double value = -12.75;

        System.out.println("Absolute value: " + abs(value));
        System.out.println("Rounded value: " + round(value));
        System.out.println("2 raised to 5: " + pow(2, 5));
        System.out.println("Maximum: " + max(14, 27));
        System.out.println("Euler's number: " + E);
    }
}
