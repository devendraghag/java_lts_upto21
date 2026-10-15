package com.example.collectionconversions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Map to List and array conversions through keys, values, and entries. */
public class MapToCollectionsDemo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Java", 90);
        scores.put("SQL", 85);
        scores.put("Spring", 95);

        List<String> keys = new ArrayList<>(scores.keySet());
        List<Integer> values = new ArrayList<>(scores.values());
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());

        String[] keyArray = scores.keySet().toArray(String[]::new);
        Integer[] valueArray = scores.values().toArray(Integer[]::new);
        Object[] entryArray = scores.entrySet().toArray();

        System.out.println("Keys as List: " + keys);
        System.out.println("Values as List: " + values);
        System.out.println("Entries as List: " + entries);
        System.out.println("Keys as array: " + java.util.Arrays.toString(keyArray));
        System.out.println("Values as array: " + java.util.Arrays.toString(valueArray));
        System.out.println("Entries as Object[]: " + java.util.Arrays.toString(entryArray));
    }
}