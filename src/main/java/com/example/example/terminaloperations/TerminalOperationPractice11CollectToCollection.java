package com.example.terminaloperations;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/** Medium: collect transfers stream elements into a collection chosen by its collector. */
public class TerminalOperationPractice11CollectToCollection {
    public static void main(String[] args) {
        List<String> words = List.of("pear", "apple", "pear", "orange");

        LinkedList<String> linked = words.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        TreeSet<String> sortedUnique = words.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("LinkedList retains duplicates and encounter order: " + linked);
        System.out.println("TreeSet sorts and removes duplicates: " + sortedUnique);
    }
}
