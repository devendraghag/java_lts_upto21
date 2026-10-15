package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator06LambdaIntegerAscendingDescending {
    public static void main(String[] args) {
        List<Integer> values = List.of(7, 2, 9, 4);
        Comparator<Integer> ascending = (a, b) -> Integer.compare(a, b);
        Comparator<Integer> descending = (a, b) -> Integer.compare(b, a);
        System.out.println(values.stream().sorted(ascending).toList());
        System.out.println(values.stream().sorted(descending).toList());
    }
}
