package com.example.collectionclasses.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> values = new HashMap<>();
        values.put("pear", 2);
        values.put("apple", 4);
        values.put("pear", 3);
        values.putIfAbsent("banana", 5);
        values.computeIfPresent("apple", (key, oldValue) -> oldValue + 1);
        values.merge("pear", 2, Integer::sum); // Merge an existing value.

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Get apple: " + values.get("apple"));
        System.out.println("LinkedHashMap conversion: " + new LinkedHashMap<>(values));
        System.out.println("TreeMap conversion: " + new TreeMap<>(values));
        System.out.println("Entry array length: " + values.entrySet().toArray().length);
        System.out.println("Default for missing key: " + values.getOrDefault("plum", 0));
        values.replaceAll((key, value) -> value * 2);
        System.out.println("After replaceAll: " + values);
        values.remove("banana", 10); // Conditional removal succeeds only if key and value match.
        // HashMap has no defined encounter order; SequencedMap methods do not apply.
    }
}
