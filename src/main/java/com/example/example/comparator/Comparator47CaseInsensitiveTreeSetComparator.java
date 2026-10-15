package com.example.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class Comparator47CaseInsensitiveTreeSetComparator {
    public static void main(String[] args) {
        Comparator<String> ignoreCaseThenExact = String.CASE_INSENSITIVE_ORDER
                .thenComparing(Comparator.naturalOrder());
        TreeSet<String> names = new TreeSet<>(ignoreCaseThenExact);
        names.add("Java");
        names.add("java");
        names.add("JAVA");
        // Exact-case tie-break means all three strings compare differently.
        System.out.println("size = " + names.size());
        System.out.println(names);
    }
}
