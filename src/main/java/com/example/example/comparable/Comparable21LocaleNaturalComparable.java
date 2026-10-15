package com.example.comparable;

import java.util.List;

public class Comparable21LocaleNaturalComparable {

    public static void main(String[] args) {
        List<String> words = List.of("�clair", "Eclair", "Zebra", "Apple");
        // String natural order compares character values and does not apply French collation rules.
        System.out.println(words.stream().sorted().toList());
    }
}
