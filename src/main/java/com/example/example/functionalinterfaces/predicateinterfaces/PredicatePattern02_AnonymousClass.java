package com.example.functionalinterfaces.predicateinterfaces;

import java.util.function.Predicate;

/** Pattern 2: use an anonymous class when the predicate is local to one place. */
public class PredicatePattern02_AnonymousClass {
    public static void main(String[] args) {
        Predicate<String> hasText = new Predicate<>() {
            @Override
            public boolean test(String value) {
                return value != null && !value.isBlank();
            }
        };

        System.out.println("Has text: " + hasText.test("Java"));
        System.out.println("Has text: " + hasText.test("   "));
    }
}