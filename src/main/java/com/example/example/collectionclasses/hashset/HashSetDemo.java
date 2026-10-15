package com.example.collectionclasses.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> values = new HashSet<>();
        values.add("pear");
        values.add("apple");
        values.add("pear"); // Duplicate is ignored.
        values.addAll(Set.of("plum", "orange"));
        values.removeIf(value -> value.startsWith("p")); // Removes every matching element.

        for (String value : values) {
            System.out.println(value); // Order is unspecified.
        }

        System.out.println("Contains apple: " + values.contains("apple"));
        Set<String> linkedCopy = new java.util.LinkedHashSet<>(values);
        System.out.println("List conversion: " + new ArrayList<>(values));
        System.out.println("LinkedHashSet conversion: " + linkedCopy);
        System.out.println("Array: " + java.util.Arrays.toString(values.toArray(String[]::new)));
        values.retainAll(Set.of("apple", "orange")); // Keeps only members of the argument set.
        System.out.println("After retainAll: " + values);
        // HashSet has no defined encounter order, so JDK 21 sequenced methods do not apply.
    }
}
