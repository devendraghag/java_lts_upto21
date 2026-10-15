package com.example.collectors;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Collectors03ToCollectionTreeSet {
    public static void main(String[] args) {
        List<String> words = List.of("pear", "apple", "plum", "apple");

        // toCollection accepts a collection factory; TreeSet removes duplicates and sorts.
        TreeSet<String> result = words.stream()
                .collect(Collectors.toCollection(TreeSet::new));
        //I only care that it is a Set.

        System.out.println(result);
    }
}
