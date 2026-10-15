package com.example.tounmodifiablelist.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Shows how to make a mutable ArrayList from the collector's result. */
public class ToUnmodifiableList04MutableCopyDemo {
    public static void main(String[] args) {
        List<String> subjects = List.of("Java", "SQL");
        List<String> unmodifiable = subjects.stream()
                .collect(Collectors.toUnmodifiableList());

        // Copy into an ArrayList if the result needs to be changed later.
        List<String> editableCopy = new ArrayList<>(unmodifiable);
        editableCopy.add("Spring");
        editableCopy.set(0, "Core Java");

        System.out.println("Unmodifiable collector result: " + unmodifiable);
        System.out.println("Mutable ArrayList copy: " + editableCopy);
    }
}
