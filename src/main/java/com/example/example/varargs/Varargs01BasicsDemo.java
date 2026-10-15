package com.example.varargs;

import java.util.Arrays;

/** Level 1: call a varargs method with zero, one, many, or an existing array. */
public class Varargs01BasicsDemo {
    public static void main(String[] args) {
        printNames(); // Zero values: Java passes an empty array.
        printNames("Asha");
        printNames("Asha", "Ravi", "Mina");

        String[] names = {"Noor", "Dev"};
        printNames(names); // An array can be passed directly to a varargs method.

        System.out.println("Sum: " + sum(10, 20, 30));
        System.out.println("Empty sum: " + sum());
    }

    // Inside the method, names is an ordinary String array.
    private static void printNames(String... names) {
        System.out.println("Names: " + Arrays.toString(names));
    }

    private static int sum(int... values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }
}
