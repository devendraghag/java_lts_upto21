package com.example.of.list;

import java.util.ArrayList;
import java.util.List;

/** Shows how to create a mutable ArrayList from a List.of() result. */
public class ListOf04MutableCopyDemo {
    public static void main(String[] args) {
        // fixedValues itself is unmodifiable.
        List<String> fixedValues = List.of("red", "green", "blue");

        // Copy the values into an ArrayList when later changes are needed.
        List<String> editableValues = new ArrayList<>(fixedValues);
        editableValues.add("yellow");
        editableValues.set(0, "crimson");

        System.out.println("List.of() source: " + fixedValues);
        System.out.println("Mutable ArrayList copy: " + editableValues);
    }
}
