package com.example.of.list;

import java.util.List;

/** Shows the common ways to create a List with List.of(). */
public class ListOf01BasicCreationDemo {
    public static void main(String[] args) {
        // The no-argument form creates an empty List<String>.
        List<String> empty = List.of();

        // A one-element list can be created with one argument.
        List<String> oneItem = List.of("Java");

        // The varargs form accepts multiple elements.
        List<String> languages = List.of("Java", "Kotlin", "Scala");

        // List.of() preserves the supplied order and permits duplicate elements.
        List<String> repeated = List.of("Java", "Java", "Kotlin");

        System.out.println("Empty list: " + empty);
        System.out.println("One item: " + oneItem);
        System.out.println("Languages: " + languages);
        System.out.println("Duplicates are allowed: " + repeated);
    }
}
