package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.Optional;
import java.util.function.Function;

/** Medium: Optional.map accepts Function<String, String>. */
public class ArbitraryObject11OptionalMap {
    public static void main(String[] args) {
        Function<String, String> lambda = text -> text.trim().toUpperCase();
        // Keep two visible steps so each reference corresponds to its own lambda.
        Optional<String> result = Optional.of("  java  ")
                .map(String::trim)
                .map(String::toUpperCase);

        System.out.println("Lambda result: " + lambda.apply("  java  "));
        System.out.println("Optional result: " + result.orElse("<empty>"));
    }
}
