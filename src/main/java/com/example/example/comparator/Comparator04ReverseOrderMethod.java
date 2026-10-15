package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator04ReverseOrderMethod {
    public static void main(String[] args) {
        List<Integer> values = List.of(4, 1, 9, 2);
        Comparator<Integer> descending = Comparator.reverseOrder();
        System.out.println(values.stream().sorted(descending).toList());
    }
}
