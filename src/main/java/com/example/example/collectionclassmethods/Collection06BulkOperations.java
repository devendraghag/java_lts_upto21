package com.example.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Collection bulk methods: addAll, removeAll, and retainAll.
 *
 * <p>{@code addAll(c)} adds every item from {@code c}. {@code removeAll(c)} removes
 * items that are also in {@code c}. {@code retainAll(c)} keeps only items that are
 * also in {@code c}. Each method returns true if this collection changed.</p>
 */
public class Collection06BulkOperations {
    public static void main(String[] args) {
        Collection<String> selected = new ArrayList<>(List.of("red", "blue"));
        boolean added = selected.addAll(List.of("green", "yellow"));
        System.out.println("addAll added the items from the other collection: " + added);
        System.out.println("After addAll: " + selected);

        boolean removed = selected.removeAll(List.of("blue", "yellow"));
        System.out.println("removeAll removed matching items: " + removed);
        System.out.println("After removeAll: " + selected);

        selected.addAll(List.of("blue", "yellow"));
        boolean retained = selected.retainAll(List.of("red", "green"));
        System.out.println("retainAll changed the collection: " + retained);
        System.out.println("After retainAll: " + selected);
    }
}
