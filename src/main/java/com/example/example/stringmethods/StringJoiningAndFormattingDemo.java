package com.example.stringmethods;

import java.util.List;
import java.util.Locale;

/** Demonstrates joining, formatting, and converting values to String. */
public class StringJoiningAndFormattingDemo {
    public static void main(String[] args) {
        String names = String.join(", ", "Asha", "Ravi", "Maya");
        System.out.println("Joined: " + names);

        String formatted = String.format(Locale.ROOT, "%-8s %4.1f", "Java", 21.0);
        System.out.println("String.format: " + formatted);

        String modernFormat = "Language: %s, version: %d".formatted("Java", 21); // Java 15+.
        System.out.println("formatted: " + modernFormat);
        System.out.println("valueOf: " + String.valueOf(123));
        System.out.println("join collection: " + String.join(" / ", List.of("one", "two")));
    }
}
