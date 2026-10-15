package com.example.functionalinterfaces.predicateinterfaces;

import java.util.Objects;
import java.util.function.Predicate;

/** Pattern 4: use static and instance method references as predicates. */
public class PredicatePattern04_MethodReferences {
    public static void main(String[] args) {
        Predicate<String> isNotNull = Objects::nonNull; // static method reference
        Predicate<String> isNotEmpty = text -> !text.isEmpty();
        Predicate<String> isBlank = String::isBlank; // instance method reference

        System.out.println(isNotNull.test("Java"));
        System.out.println(isNotEmpty.test("Java"));
        System.out.println(isBlank.test("   "));
    }
}