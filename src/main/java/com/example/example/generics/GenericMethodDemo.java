package com.example.generics;

/** Demonstrates generic methods and type inference. */
public class GenericMethodDemo {
    private static <T> void printPair(T first, T second) {
        System.out.println(first + " | " + second);
    }

    private static <T> T first(T[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        return values[0];
    }

    public static void main(String[] args) {
        printPair("left", "right"); // T is inferred as String.
        printPair(10, 20); // T is inferred as Integer.
        System.out.println("First item: " + first(new String[] {"Java", "21"}));
    }
}
