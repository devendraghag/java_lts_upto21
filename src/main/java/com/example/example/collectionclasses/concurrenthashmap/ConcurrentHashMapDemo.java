package com.example.collectionclasses.concurrenthashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> values = new ConcurrentHashMap<>();
        values.put("visits", 1);
        values.merge("visits", 1, Integer::sum);
        values.computeIfAbsent("users", key -> 3);
        values.computeIfPresent("users", (key, count) -> count + 1);
        values.putIfAbsent("errors", 0);
        values.replace("errors", 0, 1); // Conditional update succeeds only if the old value matches.

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("HashMap snapshot: " + new HashMap<>(values));
        System.out.println("Key array: " + java.util.Arrays.toString(values.keySet().toArray(String[]::new)));
        values.forEach((key, count) -> System.out.println("forEach: " + key + " -> " + count));
        System.out.println("Get default: " + values.getOrDefault("missing", 0));
        values.compute("errors", (key, count) -> count == null ? 1 : count + 1);
        System.out.println("After compute: " + values);
        // Null keys and values are forbidden; iterators are weakly consistent under concurrent updates.
    }
}
