package com.example.collectionclasses.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> values = new LinkedHashMap<>();
        values.put("third", 3);
        values.put("first", 1);
        values.put("second", 2);
        values.put("first", 10);
        values.putIfAbsent("fourth", 4);
        values.compute("second", (key, oldValue) -> oldValue == null ? 0 : oldValue + 20);

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Key order: " + values.keySet());
        System.out.println("TreeMap conversion: " + new TreeMap<>(values));
        System.out.println("HashMap conversion: " + new java.util.HashMap<>(values));
        // JDK 21 LinkedHashMap implements SequencedMap; updates can move mappings to either end.
        System.out.println("JDK 21 reversed view: " + values.reversed());
        values.putFirst("urgent", 99);
        values.putLast("last", 100);
        System.out.println("First / last entries: " + values.firstEntry() + " / " + values.lastEntry());
        System.out.println("Sequenced keys: " + values.sequencedKeySet());
        System.out.println("Remove first entry: " + values.pollFirstEntry());
    }
}
