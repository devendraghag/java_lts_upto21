package com.example.optionalclass;

import java.util.Optional;

/** Demonstrates creating Optional values and handling presence or absence. */
public class OptionalCreationAndPresenceDemo {
    public static void main(String[] args) {
        Optional<String> present = Optional.of("Java");
        Optional<String> nullable = Optional.ofNullable(null);
        Optional<String> empty = Optional.empty();

        present.ifPresent(value -> System.out.println("Present: " + value));
        System.out.println("Nullable value present: " + nullable.isPresent());
        System.out.println("Empty value is empty: " + empty.isEmpty()); // Java 11+.

        String result = empty.orElse("fallback");
        System.out.println("Result: " + result);
    }
}
