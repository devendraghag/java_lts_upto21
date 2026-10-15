package com.example.collectionclasses.concurrentskiplistmap;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> values = new ConcurrentSkipListMap<>();
        values.put(30, "thirty");
        values.put(10, "ten");
        values.put(20, "twenty");
        values.putIfAbsent(40, "forty");
        values.computeIfPresent(20, (key, value) -> value.toUpperCase());

        for (Map.Entry<Integer, String> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("First entry: " + values.firstEntry());
        System.out.println("Head map: " + values.headMap(25));
        System.out.println("TreeMap snapshot: " + new TreeMap<>(values));
        System.out.println("Descending view: " + values.descendingMap());
        System.out.println("Lower / higher key than 20: " + values.lowerKey(20) + " / " + values.higherKey(20));
        // JDK 21 SequencedMap APIs: reverse view and ordered key/entry views.
        System.out.println("JDK 21 reversed view: " + values.reversed());
        System.out.println("Sequenced keys: " + values.sequencedKeySet());
        System.out.println("Poll first entry: " + values.pollFirstEntry());
        // Its comparator defines the order, so putFirst/putLast are unsupported.
    }
}
