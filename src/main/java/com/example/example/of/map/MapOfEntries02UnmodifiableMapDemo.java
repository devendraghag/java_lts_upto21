package com.example.of.map;

import java.util.Map;

/** Demonstrates that a Map returned by Map.ofEntries() cannot be changed. */
public class MapOfEntries02UnmodifiableMapDemo {
    public static void main(String[] args) {
        Map<String, String> capitals = Map.ofEntries(
                Map.entry("India", "New Delhi"),
                Map.entry("Japan", "Tokyo")
        );

        System.out.println("Original map: " + capitals);
        System.out.println("Capital of India: " + capitals.get("India"));

        // Adding, removing, or replacing mappings throws UnsupportedOperationException.
        try {
            capitals.put("France", "Paris");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot add a mapping to a Map.ofEntries() map.");
        }

        try {
            capitals.remove("Japan");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot remove a mapping from a Map.ofEntries() map.");
        }

        System.out.println("Map after attempted changes: " + capitals);
    }
}
