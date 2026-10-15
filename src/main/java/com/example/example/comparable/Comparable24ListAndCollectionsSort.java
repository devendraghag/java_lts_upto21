package com.example.comparable;

import java.util.*;

public class Comparable24ListAndCollectionsSort {

    public static void main(String[] x) {
        List<Integer> a = new ArrayList<>(List.of(4, 1, 3));
        a.sort(null);
        List<String> b = new ArrayList<>(List.of("Zoe", "Asha", "Mira"));
        Collections.sort(b);
        System.out.println("list.sort(null) " + a);
        System.out.println("Collections.sort " + b);
        // No Comparator: compareTo provides natural order.
    }
}
