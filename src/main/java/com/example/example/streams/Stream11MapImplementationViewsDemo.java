package com.example.streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/** Compares streams over keySet() and entrySet() for common Map implementations. */
public class Stream11MapImplementationViewsDemo {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();

        addSampleData(hashMap);
        addSampleData(linkedHashMap);
        addSampleData(treeMap);

        printViews("HashMap", hashMap);
        printViews("LinkedHashMap", linkedHashMap);
        printViews("TreeMap", treeMap);
    }

    private static void addSampleData(Map<String, Integer> map) {
        // Deliberately insert keys out of alphabetical order.
        map.put("Pear", 4);
        map.put("Apple", 7);
        map.put("Orange", 2);
    }

    private static void printViews(String mapName, Map<String, Integer> map) {
        System.out.println("\n" + mapName);

        // keySet() streams only keys. The output order follows the map's iteration order.
        System.out.println("Keys: " + map.keySet().stream().toList());

        // entrySet() exposes each key and its associated value in one stream element.
        System.out.println("Entries: " + map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .toList());
    }
}