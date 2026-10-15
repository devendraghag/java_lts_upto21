package com.example.collectionclasses.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<>();
        values.addAll(List.of("Maya", "Asha", "Ravi"));
        values.add(1, "Neha");
        values.set(0, "Maya S.");
        values.remove("Ravi");
        values.removeIf(name -> name.startsWith("N")); // Predicate-based bulk removal.
        values.addAll(List.of("Ravi", "Asha"));
        values.replaceAll(String::toUpperCase); // Transform every element in place.
        values.sort(String::compareTo); // List-specific in-place sort.
        values.ensureCapacity(10); // ArrayList-specific capacity hint; does not change size.

        for (String value : values) {
            System.out.println(value);
        }

        String[] array = values.toArray(String[]::new);
        List<String> linkedListCopy = new LinkedList<>(values);
        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println("Converted to LinkedList: " + linkedListCopy);
        // JDK 21 List is sequenced: reversed() is a backed reverse-order view.
        System.out.println("JDK 21 reverse view: " + values.reversed());
        values.addFirst("FIRST");
        values.addLast("LAST");
        System.out.println("JDK 21 first / last: " + values.getFirst() + " / " + values.getLast());
        System.out.println("JDK 21 remove last: " + values.removeLast());
    }
}
