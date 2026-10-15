package com.example.collectionconversions;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** List to Set conversion removes duplicates. */
public class ListToSetDemo {
    public static void main(String[] args) {
        List<String> courses = List.of("Java", "SQL", "Java", "Spring", "SQL");

        Set<String> orderedSet = new LinkedHashSet<>(courses);
        Set<String> immutableSet = Set.copyOf(courses);

        System.out.println("Original list: " + courses);
        System.out.println("LinkedHashSet (unique, insertion order): " + orderedSet);
        System.out.println("Set.copyOf (unique, order unspecified): " + immutableSet);
    }
}