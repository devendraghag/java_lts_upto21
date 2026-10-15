package com.example.collectionclasses.hashtable;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> values = new Hashtable<>();
        values.put("one", 1);
        values.put("two", 2);
        values.putIfAbsent("three", 3);
        values.compute("two", (key, oldValue) -> oldValue == null ? 0 : oldValue + 20);

        Enumeration<String> keys = values.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + " = " + values.get(key));
        }
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.println("Entry: " + entry);
        }

        System.out.println("HashMap conversion: " + new java.util.HashMap<>(values));
        System.out.println("Array length: " + values.entrySet().toArray().length);
        System.out.println("Contains value 3: " + values.containsValue(3));
        values.replaceAll((key, value) -> value * 2);
        System.out.println("After replaceAll: " + values);
        values.remove("one", 4); // Conditional remove checks both key and current value.
        System.out.println("After conditional remove: " + values);
        // Hashtable forbids null keys/values and does not promise encounter order.
    }
}
