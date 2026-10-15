package com.example.unmodifiable.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Demonstrates that list changes through an unmodifiable view are rejected. */
public class UnmodifiableList02BlocksChangesDemo {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>(List.of("red", "green", "blue"));
        List<String> view = Collections.unmodifiableList(source);

        System.out.println("Unmodifiable view: " + view);

        // Add, remove, and replace operations through the view throw
        // UnsupportedOperationException.
        try {
            view.add("yellow");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot add through the unmodifiable view.");
        }

        try {
            view.remove("green");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot remove through the unmodifiable view.");
        }

        try {
            view.set(0, "crimson");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot replace an element through the unmodifiable view.");
        }

        System.out.println("Source remains: " + source);
    }
}
