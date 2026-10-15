package com.example.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator44BinarySearchComparator {
    public static void main(String[] args) {
        Comparator<String> byLengthThenText = Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder());
        List<String> words = new ArrayList<>(List.of("pear", "fig", "plum", "kiwi", "apricot"));
        words.sort(byLengthThenText);
        // Binary search is only valid when sorting and searching use the same comparator.
        int index = Collections.binarySearch(words, "plum", byLengthThenText);
        System.out.println("sorted = " + words);
        System.out.println("plum index = " + index);
    }
}
