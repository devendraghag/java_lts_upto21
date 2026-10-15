package com.example.of.map;

import java.util.HashMap;
import java.util.Map;

/** Shows how to create a mutable map from a Map.ofEntries() result. */
public class MapOfEntries04MutableCopyDemo {
    public static void main(String[] args) {
        // source is an unmodifiable map.
        Map<String, Integer> source = Map.ofEntries(
                Map.entry("Java", 4),
                Map.entry("SQL", 3)
        );

        // Copy the mappings into a HashMap when later changes are needed.
        Map<String, Integer> editableCopy = new HashMap<>(source);
        editableCopy.put("Spring", 5);
        editableCopy.put("Java", 6);

        System.out.println("Map.ofEntries() source: " + source);
        System.out.println("Mutable HashMap copy: " + editableCopy);
    }
}
