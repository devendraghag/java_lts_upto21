package com.example.functionalinterfaces.predicateinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/** Pattern 7: use predicates with removeIf and Stream.filter. */
public class PredicatePattern07_CollectionsAndStreams {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Predicate<Integer> isEven = value -> value % 2 == 0;

        System.out.println("Even values: " + values.stream().filter(isEven).toList());
        values.removeIf(isEven);
        System.out.println("After removing even values: " + values);
    }
}