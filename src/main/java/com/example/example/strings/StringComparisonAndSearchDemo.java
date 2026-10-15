package com.example.strings;

import java.util.Arrays;

/** String equality, ordering, searching, extraction, and splitting methods. */
public class StringComparisonAndSearchDemo {
    public static void main(String[] args) {
        String first = new String("Java Strings");
        String second = "Java Strings";

        System.out.println("== compares references: " + (first == second));
        System.out.println("equals compares contents: " + first.equals(second));
        System.out.println("Ignore case: " + first.equalsIgnoreCase("java strings"));
        System.out.println("compareTo result: " + first.compareTo("Java Streams"));

        System.out.println("Length: " + first.length());
        System.out.println("Character at 0: " + first.charAt(0));
        System.out.println("Substring: " + first.substring(5));
        System.out.println("Contains: " + first.contains("String"));
        System.out.println("Index of S: " + first.indexOf('S'));
        System.out.println("Replace: " + first.replace("Strings", "text"));

        String csv = "red,green,blue";
        System.out.println("Split: " + Arrays.toString(csv.split(",")));
        System.out.println("Split and retain delimiters (Java 21): "
                + Arrays.toString("red,green;blue".splitWithDelimiters("[,;]", -1)));
    }
}
