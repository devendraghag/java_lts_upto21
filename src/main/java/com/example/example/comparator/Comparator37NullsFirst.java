package com.example.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparator37NullsFirst {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Maya", "Arun", "Zoe"));
        names.add(null);

        Comparator<String> nullFirstCaseInsensitive =
                Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER);
        System.out.println(names.stream().sorted(nullFirstCaseInsensitive).toList());
    }
}
