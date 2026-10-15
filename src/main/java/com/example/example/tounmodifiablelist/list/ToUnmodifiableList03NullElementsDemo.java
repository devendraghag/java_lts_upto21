package com.example.tounmodifiablelist.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Shows that Collectors.toUnmodifiableList() rejects null stream elements. */
public class ToUnmodifiableList03NullElementsDemo {
    public static void main(String[] args) {
        // Arrays.asList() and its stream can contain null elements.
        List<String> source = Arrays.asList("Java", null, "SQL");

        try {
            List<String> collected = source.stream()
                    .collect(Collectors.toUnmodifiableList());
            System.out.println(collected); // This line is not reached.
        } catch (NullPointerException exception) {
            System.out.println("Collectors.toUnmodifiableList() rejects null elements.");
        }
    }
}
