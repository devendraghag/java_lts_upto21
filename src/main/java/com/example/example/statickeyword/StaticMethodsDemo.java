package com.example.statickeyword;

/** Demonstrates calling utility methods without creating an instance. */
public class StaticMethodsDemo {
    public static void main(String[] args) {
        double area = CircleMath.area(3.0);
        double circumference = CircleMath.circumference(3.0);
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
    }

    private static final class CircleMath {
        private static double area(double radius) {
            return Math.PI * radius * radius;
        }

        private static double circumference(double radius) {
            return 2 * Math.PI * radius;
        }
    }
}
