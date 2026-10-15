package com.example.of.list;

import java.util.List;

/** Demonstrates that a List returned by List.of() cannot be structurally changed. */
public class ListOf02UnmodifiableListDemo {
    public static void main(String[] args) {
        List<String> subjects = List.of("Math", "Science", "History");

        System.out.println("Original list: " + subjects);
        System.out.println("Element at index 1: " + subjects.get(1));

        // List.of() returns an unmodifiable list. Adding, removing, or replacing
        // an element throws UnsupportedOperationException.
        try {
            subjects.add("Geography");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot add an element to a List.of() list.");
        }

        try {
            subjects.set(0, "English");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot replace an element in a List.of() list.");
        }

        System.out.println("List after attempted changes: " + subjects);
    }
}
