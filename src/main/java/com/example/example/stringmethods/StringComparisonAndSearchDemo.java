package com.example.stringmethods;

import java.util.Locale;

/** Demonstrates String comparison and search methods. */
public class StringComparisonAndSearchDemo {
    public static void main(String[] args) {
        String first = "Java";
        String second = new String("Java");

        System.out.println("equals: " + first.equals(second));
        System.out.println("same reference with ==: " + (first == second));
        System.out.println("equalsIgnoreCase: " + first.equalsIgnoreCase("JAVA"));
        System.out.println("compareTo: " + first.compareTo("Kotlin"));
        System.out.println("contains: " + first.contains("av"));
        System.out.println("startsWith: " + first.startsWith("Ja"));
        System.out.println("endsWith: " + first.endsWith("va"));
        System.out.println("indexOf: " + "banana".indexOf('a'));
        System.out.println("lastIndexOf: " + "banana".lastIndexOf('a'));
        System.out.println("locale independent lowercase: " + first.toLowerCase(Locale.ROOT));
    }
}
