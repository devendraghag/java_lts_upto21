package com.example.comparable;

import java.util.*;

public class Comparable03StringNaturalOrder {

    public static void main(String[] x) {
        String a = "Asha", b = "Mira";
        // String.compareTo uses lexicographic natural order.
        System.out.println(a.compareTo(b));
        System.out.println(List.of("Zoe", "Asha", "Mira").stream().sorted().toList());
        // sorted() calls compareTo internally.
    }
}
