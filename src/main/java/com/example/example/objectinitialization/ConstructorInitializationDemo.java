package com.example.objectinitialization;

/** Demonstrates no-argument, parameterized, and chained constructors. */
public class ConstructorInitializationDemo {
    private static final class Book {
        private final String title;
        private final int pages;

        private Book() {
            this("Untitled", 0);
        }

        private Book(String title) {
            this(title, 0);
        }

        private Book(String title, int pages) {
            this.title = title;
            this.pages = pages;
        }

        @Override
        public String toString() {
            return title + " (" + pages + " pages)";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Book());
        System.out.println(new Book("Java Basics"));
        System.out.println(new Book("Java 21", 500));
    }
}
