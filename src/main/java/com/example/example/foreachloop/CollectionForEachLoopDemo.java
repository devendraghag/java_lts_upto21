package com.example.foreachloop;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Demonstrates enhanced for loops over Iterable collection types. */
public class CollectionForEachLoopDemo {
    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Kotlin", "Scala");
        for (String language : languages) {
            System.out.println("List item: " + language);
        }

        Set<String> tools = new LinkedHashSet<>(List.of("javac", "jshell", "javadoc"));
        for (String tool : tools) {
            System.out.println("Set item: " + tool);
        }
    }
}
