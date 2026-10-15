package com.example.variables;

/** Level 10: Binary numeric promotion for byte, short, and char arithmetic. */
public class Variable10NumericPromotionDemo {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 10;
        // byte c = a + b; // Compile-time error: the sum is promoted to int.
        int promotedSum = a + b;
        byte c = (byte) (a + b);
        System.out.println("Promoted result type is int: " + promotedSum);
        System.out.println("Explicitly narrowed byte: " + c); // 20

        char letter = 'A';
        int nextCodePoint = letter + 1; // char is promoted to int for arithmetic.
        char nextLetter = (char) nextCodePoint;
        System.out.println("Character arithmetic as int: " + nextCodePoint); // 66
        System.out.println("After casting back to char: " + nextLetter); // B
    }
}
