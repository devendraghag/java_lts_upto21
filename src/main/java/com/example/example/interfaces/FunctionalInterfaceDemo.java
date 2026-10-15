package com.example.interfaces;

/** Demonstrates a functional interface used with a lambda expression. */
public class FunctionalInterfaceDemo {
    @FunctionalInterface
    private interface TextConverter {
        String convert(String input); // The single abstract method.

        default String convertOrEmpty(String input) {
            return convert(input == null ? "" : input);
        }
    }

    public static void main(String[] args) {
        TextConverter converter = text -> text.trim().toUpperCase();
        System.out.println(converter.convertOrEmpty("  Java  "));
        System.out.println(converter.convertOrEmpty(null));
    }
}
