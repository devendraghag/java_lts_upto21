package com.example.comparable;

import java.util.*;

public class Comparable32AllAnyNoneNaturalChecks {

    public static void main(String[] x) {
        List<String> n = List.of("ant", "bee", "cat");
        String boundary = "bee";
        System.out.println(n.stream().allMatch(v -> v.compareTo("zoo") < 0));
        System.out.println(n.stream().anyMatch(v -> v.compareTo(boundary) == 0));
        System.out.println(n.stream().noneMatch(v -> v.compareTo("aardvark") < 0));
        // Predicates directly use String.compareTo.
    }
}
