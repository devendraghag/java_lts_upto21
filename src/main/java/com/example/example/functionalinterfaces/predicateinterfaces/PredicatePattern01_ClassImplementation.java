package com.example.functionalinterfaces.predicateinterfaces;

import java.util.function.Predicate;

/** Pattern 1: implement the functional interface in a named class. */
public class PredicatePattern01_ClassImplementation {
    private static final class IsEven implements Predicate<Integer> {
        @Override
        public boolean test(Integer number) {
            return number % 2 == 0;
        }
    }

    public static void main(String[] args) {
        Predicate<Integer> isEven = new IsEven();
        System.out.println("Is 8 even? " + isEven.test(8));
    }
}