package com.example.callbyvalue;

import java.util.Arrays;

/** Demonstrates mutation and reassignment of an array parameter. */
public class ArrayArgumentDemo {
    private static void updateFirstAndReassign(int[] values) {
        values[0] = 100; // Mutates the shared array object.
        values = new int[] {7, 8, 9}; // Reassigns only this method's copied reference.
        values[0] = 700;
        System.out.println("Inside method: " + Arrays.toString(values));
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        updateFirstAndReassign(numbers);
        System.out.println("After method: " + Arrays.toString(numbers));
    }
}
