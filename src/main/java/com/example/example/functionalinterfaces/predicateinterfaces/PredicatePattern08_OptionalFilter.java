package com.example.functionalinterfaces.predicateinterfaces;

import java.util.Optional;
import java.util.function.Predicate;

/** Pattern 8: conditionally keep an Optional value with Predicate. */
public class PredicatePattern08_OptionalFilter {
    public static void main(String[] args) {
        Predicate<String> isLongEnough = text -> text.length() >= 4;

        Optional<String> accepted = Optional.of("Java").filter(isLongEnough);
        Optional<String> rejected = Optional.of("SQL").filter(isLongEnough);
        System.out.println("Accepted: " + accepted.orElse("none"));
        System.out.println("Rejected: " + rejected.orElse("none"));
    }
}