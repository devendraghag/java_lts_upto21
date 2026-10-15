package com.example.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparable26BinarySearchComparable {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("pear", "fig", "plum", "kiwi", "apricot"));
        Collections.sort(words); // Uses String's natural order.
        int index = Collections.binarySearch(words, "plum"); // Search must use that same order.
        System.out.println("sorted = " + words);
        System.out.println("plum index = " + index);
    }
}
