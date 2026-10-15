package com.example.functionalinterfaces.predicateinterfaces;

import java.util.function.Predicate;

/** Pattern 3: express a predicate directly as a lambda. */
public class PredicatePattern03_Lambda {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = number -> number > 0;
        System.out.println("5 is positive: " + isPositive.test(5));
        System.out.println("-2 is positive: " + isPositive.test(-2));
    }
}