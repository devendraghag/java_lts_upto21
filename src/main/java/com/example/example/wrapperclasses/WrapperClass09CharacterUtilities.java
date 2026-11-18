package com.example.example.wrapperclasses;

/** Character provides useful tests and conversions for individual char values. */
public class WrapperClass09CharacterUtilities {
    public static void main(String[] args) {
        char value = '7';

        System.out.println("Is digit: " + Character.isDigit(value));
        System.out.println("Numeric value: " + Character.getNumericValue(value));
        System.out.println("Uppercase form of 'j': " + Character.toUpperCase('j'));
        System.out.println("Is whitespace: " + Character.isWhitespace(' '));
    }
}
