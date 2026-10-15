package com.example.copyof.list;

import java.util.ArrayList;
import java.util.List;

/** Demonstrates that a list returned by List.copyOf() cannot be changed. */
public class ListCopyOf02UnmodifiableListDemo {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>(List.of("red", "green", "blue"));
        List<String> copied = List.copyOf(source);

        System.out.println("Copied list: " + copied);

        // Adding, removing, or replacing an element throws UnsupportedOperationException.
        try {
            copied.add("yellow");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot add an element to a List.copyOf() result.");
        }

        try {
            copied.set(0, "crimson");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot replace an element in a List.copyOf() result.");
        }

        System.out.println("Copied list after attempted changes: " + copied);
    }
}
