package com.example.collectionclasses.weakhashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        Object key = new Object(); // Strong reference keeps this key reachable here.
        WeakHashMap<Object, String> values = new WeakHashMap<>();
        values.put(key, "metadata");
        values.putIfAbsent("permanent-example-key", "still weakly keyed");
        values.computeIfPresent(key, (ignored, oldValue) -> oldValue.toUpperCase());

        for (Map.Entry<Object, String> entry : values.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("Lookup while key is reachable: " + values.get(key));
        HashMap<Object, String> strongCopy = new HashMap<>(values);
        System.out.println("HashMap snapshot conversion: " + strongCopy);
        System.out.println("WeakHashMap size now: " + values.size());
        System.out.println("Contains key: " + values.containsKey(key));
        values.remove(key);
        System.out.println("After removing strongly held key: " + values);
        // Values are strongly held; a value that refers back to its weak key can prevent collection.
    }
}
