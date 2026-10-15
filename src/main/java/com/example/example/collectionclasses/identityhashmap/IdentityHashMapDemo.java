package com.example.collectionclasses.identityhashmap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> values = new IdentityHashMap<>();
        String firstKey = new String("same");
        String secondKey = new String("same");
        values.put(firstKey, 1);
        values.put(secondKey, 2);
        values.put(new String("third"), 3);

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("IdentityHashMap size: " + values.size());
        HashMap<String, Integer> equalityBasedCopy = new HashMap<>(values);
        System.out.println("HashMap size after conversion: " + equalityBasedCopy.size());
        System.out.println("Identity lookup using first reference: " + values.get(firstKey));
        System.out.println("Equal but different reference lookup: " + values.get(new String("same")));
        values.replaceAll((key, value) -> value * 10);
        System.out.println("After replaceAll: " + values);
        // IdentityHashMap compares keys with ==, unlike ordinary maps that use equals().
    }
}
