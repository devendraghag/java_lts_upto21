package com.example.of.map;

import java.util.Map;

/** Shows how Map.ofEntries() creates a map from Map.Entry values. */
public class MapOfEntries01BasicCreationDemo {
    public static void main(String[] args) {
        // No entries creates an empty map.
        Map<String, Integer> empty = Map.ofEntries();

        // Map.entry() creates each key-value pair passed to Map.ofEntries().
        Map<String, Integer> courseCredits = Map.ofEntries(
                Map.entry("Java", 4),
                Map.entry("SQL", 3),
                Map.entry("Spring", 5)
        );

        System.out.println("Empty map: " + empty);
        System.out.println("Course credits: " + courseCredits);
        System.out.println("Credits for Java: " + courseCredits.get("Java"));

        // Map.ofEntries() does not promise a particular iteration order.
    }
}
