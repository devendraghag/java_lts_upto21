package com.example.collectionconversions;


import java.util.List;

/*
 * JDK 11 introduction-version bucket feature: Collection.toArray(IntFunction<T[]>).
 *
 * This compact form avoids manually passing a zero-length array.
 */
/**
 * Easy: Demonstrates Collection To Array01 Basic Demo in the Collection To Array topic.
 * Run it to observe the basic behavior and output.
 * Medium: Track element order, duplicates, lookup behavior, and the collection state after each operation.
 * Tough: Analyze complexity, mutation during iteration, view behavior, and unsupported operations.
 */
public class CollectionToArray01BasicDemo {
    public static void main(String[] args) {
        List<String> courses = List.of("Java", "Spring", "SQL");

        String[] result = courses.toArray(String[]::new);

        for (String course : result) {
            System.out.println(course);
        }
    }
}

