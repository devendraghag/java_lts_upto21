package com.example.varargs;

import java.util.Arrays;

/** Level 3: accept a variable number of values in a constructor. */
public class Varargs03ConstructorDemo {
    public static void main(String[] args) {
        Book authored = new Book("Java Guide", "Asha", "Ravi");
        Book authorUnknown = new Book("Untitled"); // No authors is also valid.

        System.out.println(authored);
        System.out.println(authorUnknown);
    }

    private static final class Book {
        private final String title;
        private final String[] authors;

        private Book(String title, String... authors) {
            this.title = title;
            this.authors = authors.clone(); // Keep a defensive copy of the caller's array.
        }

        @Override
        public String toString() {
            return title + " by " + Arrays.toString(authors);
        }
    }
}
