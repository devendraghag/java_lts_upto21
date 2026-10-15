package com.example.datatypes;

/** Demonstrates primitive wrappers, boxing, parsing, and numeric conversions. */
public class WrapperAndConversionDemo {
    public static void main(String[] args) {
        int primitive = 25;
        Integer boxed = primitive; // Autoboxing: int to Integer.
        int unboxed = boxed;       // Unboxing: Integer to int.

        Integer parsedInteger = Integer.valueOf("123");
        double parsedDouble = Double.parseDouble("4.5");
        System.out.println("Boxed and unboxed: " + boxed + " -> " + unboxed);
        System.out.println("Parsed values: " + parsedInteger + ", " + parsedDouble);

        byte small = 100;
        int widened = small;           // Widening conversion is implicit.
        int large = 300;
        byte narrowed = (byte) large;  // Narrowing conversion requires a cast and can lose data.
        System.out.println("Widened byte to int: " + widened);
        System.out.println("Narrowed 300 to byte: " + narrowed);

        int roundedByCast = (int) 9.99;
        System.out.println("Casting double to int truncates: " + roundedByCast);

        Integer absent = null;
        try {
            int invalidUnboxing = absent;
            System.out.println(invalidUnboxing);
        } catch (NullPointerException exception) {
            System.out.println("Unboxing null throws NullPointerException");
        }
    }
}
