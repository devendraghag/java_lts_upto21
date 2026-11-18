package com.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;

/** {@code add(E e)} puts one item {@code e} into this collection and returns whether it changed. */
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
