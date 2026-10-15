package com.example.streams;

import java.util.HashMap;
import java.util.Map;

/** Starts with streaming a map's key-value entries. */
public class Stream08MapEntrySetDemo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Asha", 91);
        scores.put("Ben", 76);
        scores.put("Cara", 88);
        scores.put("Dev", 64);

        // entrySet() gives a collection of Map.Entry objects. Each entry has a key and a value.
        scores.entrySet().stream()
                // Keep only passing scores.
                .filter(entry -> entry.getValue() >= 75)
                // Sort by score from highest to lowest, then by name for ties.
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                // Convert each entry into a readable line.
                .map(entry -> entry.getKey() + " scored " + entry.getValue())
                .forEach(System.out::println);
    }
}