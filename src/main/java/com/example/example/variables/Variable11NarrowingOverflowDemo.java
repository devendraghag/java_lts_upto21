package com.example.variables;

/** Level 11: Shows the result of narrowing an int outside the byte range. */
public class Variable11NarrowingOverflowDemo {
    public static void main(String[] args) {
        int a = 130;
        byte b = (byte) a;
        System.out.println(a); // 130
        System.out.println(b); // -126

        // A byte stores values from -128 through 127. Narrowing keeps the low eight bits.
        int negative = -130;
        byte narrowedNegative = (byte) negative;
        System.out.println(negative); // -130
        System.out.println(narrowedNegative); // 126
    }
}
