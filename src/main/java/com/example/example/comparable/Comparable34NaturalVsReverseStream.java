package com.example.comparable;

import java.util.*;

public class Comparable34NaturalVsReverseStream {

    public static void main(String[] x) {
        List<Integer> n = List.of(7, 2, 5);
        System.out.println(n.stream().sorted().toList());
        System.out.println(n.stream().sorted(Comparator.reverseOrder()).toList());
        // Comparator changes this pipeline only; Integer natural order remains unchanged.
    }
}
