package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator61NamesByLength {
    public static void main(String[] args) {
        List<String> names = List.of("Li", "Mira", "Asha", "Bo");
        Comparator<String> byLengthThenName = Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder());
        System.out.println(names.stream().sorted(byLengthThenName).toList());
    }
}
