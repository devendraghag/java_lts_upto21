package com.example.of.map;

import java.util.AbstractMap;
import java.util.Map;

/** Shows invalid inputs rejected by Map.ofEntries(). */
public class MapOfEntries03InvalidEntriesDemo {
    public static void main(String[] args) {
        // Duplicate keys are not allowed, even if their values are different.
        try {
            Map<String, Integer> duplicateKeys = Map.ofEntries(
                    Map.entry("Java", 4),
                    Map.entry("Java", 5)
            );
            System.out.println(duplicateKeys); // This line is not reached.
        } catch (IllegalArgumentException exception) {
            System.out.println("Map.ofEntries() rejects duplicate keys.");
        }

        // SimpleEntry can hold null, allowing us to show Map.ofEntries() rejects it.
        try {
            Map<String, Integer> nullValue = Map.ofEntries(
                    new AbstractMap.SimpleEntry<>("Java", null)
            );
            System.out.println(nullValue); // This line is not reached.
        } catch (NullPointerException exception) {
            System.out.println("Map.ofEntries() rejects null values.");
        }

        try {
            Map<String, Integer> nullKey = Map.ofEntries(
                    new AbstractMap.SimpleEntry<>(null, 4)
            );
            System.out.println(nullKey); // This line is not reached.
        } catch (NullPointerException exception) {
            System.out.println("Map.ofEntries() rejects null keys.");
        }
    }
}
