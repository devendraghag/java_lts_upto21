package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Intermediate: addAll, removeAll, and retainAll operate on groups of elements. */
public class Collection06BulkOperations {
    public static void main(String[] args) {
        Collection<String> selected = new ArrayList<>(List.of("red", "blue"));
        selected.addAll(List.of("green", "yellow"));
        System.out.println("After addAll: " + selected);

        selected.removeAll(List.of("blue", "yellow"));
        System.out.println("After removeAll: " + selected);

        selected.addAll(List.of("blue", "yellow"));
        selected.retainAll(List.of("red", "green"));
        System.out.println("After retainAll: " + selected);
    }
}