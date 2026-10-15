package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator30UserNameComparator {
    public static void main(String[] args) {
        List<String> names = List.of("sam", "SAM", "Sam");

        // The second comparator preserves distinct spellings when the case-insensitive keys tie.
        Comparator<String> order = String.CASE_INSENSITIVE_ORDER
                .thenComparing(Comparator.naturalOrder());
        System.out.println(names.stream().sorted(order).toList());
    }
}
