package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;

/** Beginner: create a Collection reference and add elements. */
public class Collection01CreatingAndAdding {
    public static void main(String[] args) {
        Collection<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Kotlin");
        languages.add("Java"); // Collection permits duplicates; implementations decide details.

        System.out.println("Languages: " + languages);
        System.out.println("Added Rust: " + languages.add("Rust"));
        System.out.println("After adding Rust: " + languages);
    }
}