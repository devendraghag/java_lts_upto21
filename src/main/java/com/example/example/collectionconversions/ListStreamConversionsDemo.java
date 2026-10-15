package com.example.collectionconversions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Convert between a List and the results of Stream pipelines. */
public class ListStreamConversionsDemo {
    public static void main(String[] args) {
        List<String> courses = List.of("Java", "Spring", "SQL", "JavaScript");

        List<String> unmodifiableResult = courses.stream()
                .filter(course -> course.length() > 3)
                .map(String::toUpperCase)
                .toList();

        List<String> mutableResult = courses.stream()
                .filter(course -> course.length() > 3)
                .collect(Collectors.toCollection(ArrayList::new));
        mutableResult.add("DOCKER");

        System.out.println("Stream to unmodifiable List: " + unmodifiableResult);
        System.out.println("Stream to mutable ArrayList: " + mutableResult);
    }
}