package com.example.comparable;

import java.util.*;

public class Comparable28StreamsMinMax {

    public static void main(String[] x) {
        List<Integer> n = List.of(8, 2, 5);
        System.out.println("sorted " + n.stream().sorted().toList());
        System.out.println("min " + n.stream().min(Comparator.naturalOrder()).orElseThrow());
        System.out.println("max " + n.stream().max(Comparator.naturalOrder()).orElseThrow());
        System.out.println("max" + n.stream().sorted(Comparator.naturalOrder()).toList());
        // Natural comparator delegates to compareTo.
    }
}
