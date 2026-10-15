package com.example.functionalinterfaces.predicateinterfaces;

import java.util.function.Predicate;

/** Pattern 6: reuse and combine predicates with and, or, and negate. */
public class PredicatePattern06_ReuseAndCompose {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = number -> number > 0;
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> positiveEven = isPositive.and(isEven);

        System.out.println(positiveEven.test(12));
        System.out.println(positiveEven.test(-4));
        System.out.println(isEven.negate().test(7));
    }
}