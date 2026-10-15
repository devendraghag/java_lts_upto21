package com.example.example.methodoverriding;

/** Rule 19: toString() can be overridden to provide a useful text representation. */
public class Rule19OverrideObjectToString {
    static class Book {
        private final String title;
        Book(String title) { this.title = title; }
        @Override public String toString() { return "Book: " + title; }
    }
    public static void main(String[] args) { System.out.println(new Book("Java")); }
}
