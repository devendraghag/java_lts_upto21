package com.example.comparable;

import java.util.TreeSet;

public class Comparable39CaseInsensitiveTreeSetComparable {
    record Name(String value) implements Comparable<Name> {
        @Override
        public int compareTo(Name other) {
            // Intentionally omits an exact-case tie-breaker to show sorted-set equivalence.
            return value.compareToIgnoreCase(other.value);
        }
    }

    public static void main(String[] args) {
        TreeSet<Name> names = new TreeSet<>();
        names.add(new Name("Java"));
        names.add(new Name("java"));
        names.add(new Name("JAVA"));
        System.out.println("size = " + names.size());
        System.out.println(names);
    }
}
