package com.example.stringbuilder;

/** Demonstrates reading and searching characters in a StringBuilder. */
public class StringBuilderSearchDemo {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("Java makes Java applications");

        System.out.println("Character at index 0: " + text.charAt(0));
        System.out.println("First Java index: " + text.indexOf("Java"));
        System.out.println("Last Java index: " + text.lastIndexOf("Java"));
        System.out.println("Substring: " + text.substring(5, 10));
        System.out.println("Sequence: " + text.subSequence(0, 4));

        StringBuilder left = new StringBuilder("alpha");
        StringBuilder right = new StringBuilder("beta");
        System.out.println("compareTo result: " + left.compareTo(right));
    }
}
