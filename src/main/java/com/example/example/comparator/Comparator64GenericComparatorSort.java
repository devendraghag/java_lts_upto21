package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator64GenericComparatorSort {
    // Comparator<? super T> accepts a comparator for T or one of T's supertypes.
    private static <T> List<T> sortBy(List<T> values, Comparator<? super T> order) {
        return values.stream().sorted(order).toList();
    }

    public static void main(String[] args) {
        System.out.println(sortBy(List.of(8, 2, 5), Comparator.reverseOrder()));
        System.out.println(sortBy(List.of("pear", "apple", "plum"),
                Comparator.comparingInt(String::length)));
    }
}
