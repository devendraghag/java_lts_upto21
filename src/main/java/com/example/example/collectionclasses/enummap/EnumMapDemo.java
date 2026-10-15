package com.example.collectionclasses.enummap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapDemo {
    private enum Day { MONDAY, TUESDAY, WEDNESDAY }

    public static void main(String[] args) {
        EnumMap<Day, String> values = new EnumMap<>(Day.class);
        values.put(Day.MONDAY, "planning");
        values.put(Day.TUESDAY, "coding");
        values.put(Day.WEDNESDAY, "review");
        values.putIfAbsent(Day.MONDAY, "duplicate ignored");
        values.computeIfPresent(Day.TUESDAY, (day, task) -> task.toUpperCase());

        for (Map.Entry<Day, String> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Value for TUESDAY: " + values.get(Day.TUESDAY));
        System.out.println("HashMap conversion: " + new HashMap<>(values));
        System.out.println("Keys: " + values.keySet());
        System.out.println("Contains WEDNESDAY: " + values.containsKey(Day.WEDNESDAY));
        values.merge(Day.MONDAY, " and planning", String::concat);
        System.out.println("After merge: " + values);
        values.remove(Day.WEDNESDAY);
        System.out.println("After remove: " + values);
        // EnumMap iterates keys in enum declaration order and rejects null keys.
    }
}
