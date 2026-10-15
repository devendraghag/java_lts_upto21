package com.example.statickeyword;

import static java.lang.Math.PI;
import static java.lang.Math.max;

/** Demonstrates importing static members for unqualified use. */
public class StaticImportDemo {
    public static void main(String[] args) {
        double circleArea = PI * 2 * 2;
        int larger = max(12, 20);
        System.out.println("Circle area: " + circleArea);
        System.out.println("Larger value: " + larger);
    }
}
