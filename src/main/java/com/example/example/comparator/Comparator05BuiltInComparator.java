package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator05BuiltInComparator {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 1, 3);
        System.out.println(numbers.stream()
                .sorted(Comparator.naturalOrder()).toList());
        System.out.println(numbers.stream()
                .sorted(Comparator.reverseOrder()).toList());

        List<String> names = List.of("Zoe", "Ada", "Linus");
        System.out.println(names.stream()
                .sorted(Comparator.reverseOrder()).toList());
    }
}
