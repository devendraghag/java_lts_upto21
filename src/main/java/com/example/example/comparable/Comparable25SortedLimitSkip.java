package com.example.comparable;

import java.util.*;

public class Comparable25SortedLimitSkip {

    public static void main(String[] x) {
        List<String> n = List.of("Mira", "Asha", "Dev", "Zoe");
        System.out.println("first two " + n.stream().sorted().limit(2).toList());
        System.out.println("after first two " + n.stream().sorted().skip(2).toList());
        // sorted uses String.compareTo.
    }
}
