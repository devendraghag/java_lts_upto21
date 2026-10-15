package com.example.collectionclasses.linkedhashset;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> values = new LinkedHashSet<>();
        values.add("pear");
        values.add("apple");
        values.addAll(java.util.Set.of("plum", "orange"));
        values.remove("banana");
        values.add("banana");
        values.add("apple");

        for (String value : values) {
            System.out.println(value); // Insertion order.
        }

        System.out.println("List conversion: " + new ArrayList<>(values));
        System.out.println("TreeSet conversion: " + new TreeSet<>(values));
        System.out.println("Array: " + java.util.Arrays.toString(values.toArray(String[]::new)));
        // JDK 21 LinkedHashSet implements SequencedSet; reversed() is a backed view.
        System.out.println("JDK 21 reverse view: " + values.reversed());
        values.addFirst("first");
        values.addLast("last");
        System.out.println("First / last: " + values.getFirst() + " / " + values.getLast());
        System.out.println("Remove first: " + values.removeFirst());
    }
}
