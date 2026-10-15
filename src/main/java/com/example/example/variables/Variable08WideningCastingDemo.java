package com.example.variables;

/** Level 08: Implicit widening primitive conversions. */
public class Variable08WideningCastingDemo {
    public static void main(String[] args) {
        int a = 10;
        float f = a; // int widens to float without an explicit cast.
        System.out.println(a); // 10
        System.out.println(f); // 10.0

        // Widening avoids a cast, but int-to-float can lose precision for large values.
        int large = 16_777_217;
        float rounded = large;
        System.out.println("Large int: " + large);
        System.out.println("As float: " + rounded);
    }
}
