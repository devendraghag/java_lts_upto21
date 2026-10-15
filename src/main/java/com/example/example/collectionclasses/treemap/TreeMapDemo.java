package com.example.collectionclasses.treemap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> values = new TreeMap<>();
        values.put(30, "thirty");
        values.put(10, "ten");
        values.put(20, "twenty");
        values.putIfAbsent(40, "forty");
        values.computeIfPresent(20, (key, value) -> value.toUpperCase());

        for (Map.Entry<Integer, String> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("First entry: " + values.firstEntry());
        System.out.println("Floor entry for 25: " + values.floorEntry(25));
        System.out.println("Descending map: " + values.descendingMap());
        System.out.println("LinkedHashMap conversion: " + new LinkedHashMap<>(values));
        System.out.println("Lower / higher key than 20: " + values.lowerKey(20) + " / " + values.higherKey(20));
        // JDK 21 TreeMap implements SequencedMap; reversed() preserves a live reverse-order view.
        System.out.println("JDK 21 reversed view: " + values.reversed());
        // TreeMap is sequenced in JDK 21, but putFirst/putLast are unsupported because
        // its comparator, rather than insertion position, determines encounter order.
        values.put(5, "five");
        values.put(50, "fifty");
        System.out.println("Sequenced keys: " + values.sequencedKeySet());
        System.out.println("Poll last entry: " + values.pollLastEntry());
    }
}
