package com.example.comparable;

import java.util.List;

public class Comparable50GenericNaturalSort {
    // The bound guarantees every T can compare itself with T (or a compatible supertype).
    private static <T extends Comparable<? super T>> List<T> sortNaturally(List<T> values) {
        return values.stream().sorted().toList();
    }

    public static void main(String[] args) {
        System.out.println(sortNaturally(List.of(8, 2, 5)));
        System.out.println(sortNaturally(List.of("pear", "apple", "plum")));
    }
}
