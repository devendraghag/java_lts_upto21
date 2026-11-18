package com.example.example.wrapperclasses;

/** parseBoolean returns true only for text equal to true ignoring case. */
public class WrapperClass08BooleanParsing {
    public static void main(String[] args) {
        System.out.println("'true': " + Boolean.parseBoolean("true"));
        System.out.println("'TRUE': " + Boolean.parseBoolean("TRUE"));
        System.out.println("'yes': " + Boolean.parseBoolean("yes"));
        System.out.println("null: " + Boolean.parseBoolean(null));
    }
}
