package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator07LambdaStrings {
    public static void main(String[] args) {
        List<String> names = List.of("mira", "Asha", "Bo");
        Comparator<String> ignoreCase = (a, b) -> a.compareToIgnoreCase(b);
        System.out.println(names.stream().sorted(ignoreCase).toList());
    }
}
