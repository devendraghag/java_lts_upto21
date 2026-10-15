package com.example.optionalclass;

import java.util.Optional;

/** Demonstrates converting a possibly null result to Optional at an API boundary. */
public class OptionalBoundaryDemo {
    private static String legacyLookup(String key) {
        return key.equals("known") ? "value" : null;
    }

    private static Optional<String> lookup(String key) {
        return Optional.ofNullable(legacyLookup(key));
    }

    public static void main(String[] args) {
        System.out.println(lookup("known").orElse("not found"));
        System.out.println(lookup("missing").orElse("not found"));
    }
}
