package com.example.copyof.list;

import java.util.ArrayList;
import java.util.List;

/** Shows how List.copyOf() creates an unmodifiable snapshot of a collection. */
public class ListCopyOf01SnapshotDemo {
    public static void main(String[] args) {
        // The source list is mutable and may contain duplicate values.
        List<String> source = new ArrayList<>(List.of("Java", "SQL", "Java"));

        // List.copyOf() copies the elements in their current iteration order.
        List<String> snapshot = List.copyOf(source);

        // Later structural changes to the source do not change the snapshot.
        source.add("Spring");

        System.out.println("Source after adding Spring: " + source);
        System.out.println("Snapshot: " + snapshot);
    }
}
