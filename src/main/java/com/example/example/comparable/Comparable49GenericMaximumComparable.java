package com.example.comparable;

import java.util.Comparator;
import java.util.List;

public class Comparable49GenericMaximumComparable {
    // The bound guarantees that T has a natural ordering compatible with T.
    private static <T extends Comparable<? super T>> T maximum(List<T> values) {
        return values.stream().max(Comparator.naturalOrder()).orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println("maximum integer = " + maximum(List.of(4, 9, 2)));
        System.out.println("maximum word = " + maximum(List.of("pear", "plum", "apple")));
    }
}
