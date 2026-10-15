package com.example.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparator38NullsLast {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Maya", "Arun", "Zoe"));
        names.add(null);

        // Put nullsLast outside the reversed value order to keep null at the end.
        Comparator<String> descendingWithNullLast =
                Comparator.nullsLast(Comparator.reverseOrder());
        System.out.println(names.stream().sorted(descendingWithNullLast).toList());
    }
}
