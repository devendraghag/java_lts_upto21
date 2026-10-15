package com.example.copyof.list;

import java.util.ArrayList;
import java.util.List;

/** Shows how to make a mutable ArrayList from a List.copyOf() result. */
public class ListCopyOf04MutableCopyDemo {
    public static void main(String[] args) {
        List<String> source = List.of("Java", "SQL");
        List<String> unmodifiableCopy = List.copyOf(source);

        // Wrap the copied values in ArrayList when later changes are needed.
        List<String> editableCopy = new ArrayList<>(unmodifiableCopy);
        editableCopy.add("Spring");
        editableCopy.set(0, "Core Java");

        System.out.println("List.copyOf() result: " + unmodifiableCopy);
        System.out.println("Mutable ArrayList copy: " + editableCopy);
    }
}
