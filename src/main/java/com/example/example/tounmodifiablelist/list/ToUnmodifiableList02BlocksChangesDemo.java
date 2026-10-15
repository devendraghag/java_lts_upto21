package com.example.tounmodifiablelist.list;

import java.util.List;
import java.util.stream.Collectors;

/** Demonstrates that the collected list cannot be structurally changed. */
public class ToUnmodifiableList02BlocksChangesDemo {
    public static void main(String[] args) {
        List<String> colors = List.of("red", "green", "blue");
        List<String> collected = colors.stream()
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Collected list: " + collected);

        // Add, remove, and replace operations throw UnsupportedOperationException.
        try {
            collected.add("yellow");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot add an element to this collected list.");
        }

        try {
            collected.remove("green");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot remove an element from this collected list.");
        }

        try {
            collected.set(0, "crimson");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot replace an element in this collected list.");
        }

        System.out.println("List after attempted changes: " + collected);
    }
}
