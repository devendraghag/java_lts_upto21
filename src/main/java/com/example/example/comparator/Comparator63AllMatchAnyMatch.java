package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator63AllMatchAnyMatch {
    public static void main(String[] args) {
        List<Integer> scores = List.of(2, 4, 6, 8);
        Comparator<Integer> ascending = Integer::compare;
        int boundary = 6;

        boolean allAtMostBoundary = scores.stream()
                .allMatch(value -> ascending.compare(value, boundary) <= 0);
        boolean anyAboveBoundary = scores.stream()
                .anyMatch(value -> ascending.compare(value, boundary) > 0);

        System.out.println("all <= 6 = " + allAtMostBoundary);
        System.out.println("any > 6 = " + anyAboveBoundary);
    }
}
