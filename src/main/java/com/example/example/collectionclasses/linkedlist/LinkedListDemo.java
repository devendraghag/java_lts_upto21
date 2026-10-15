package com.example.collectionclasses.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> values = new LinkedList<>(List.of("middle"));
        values.addFirst("first");
        values.addLast("last");
        values.add(1, "before middle");
        values.offerFirst("offered-first"); // Queue-style insertion at the head.
        values.offerLast("offered-last"); // Queue-style insertion at the tail.
        values.removeFirstOccurrence("before middle");
        values.removeLastOccurrence("offered-last");

        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("First/last: " + values.getFirst() + " / " + values.getLast());
        System.out.println("ArrayList conversion: " + new ArrayList<>(values));
        System.out.println("Array: " + java.util.Arrays.toString(values.toArray(String[]::new)));
        // JDK 21 SequencedCollection APIs also apply to LinkedList.
        System.out.println("Reverse view: " + values.reversed());
        System.out.println("Poll first / last: " + values.pollFirst() + " / " + values.pollLast());
    }
}
