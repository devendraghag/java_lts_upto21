package com.example.unmodifiable.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Shows how to make a mutable copy of an unmodifiable list view. */
public class UnmodifiableList04MutableCopyDemo {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>(List.of("Java", "SQL"));
        List<String> view = Collections.unmodifiableList(source);

        // Copy the current elements into a separate mutable ArrayList.
        List<String> editableCopy = new ArrayList<>(view);
        editableCopy.add("Spring");
        editableCopy.set(0, "Core Java");

        System.out.println("Unmodifiable view: " + view);
        System.out.println("Mutable copy: " + editableCopy);
    }
}
