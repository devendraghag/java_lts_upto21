package com.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/** Advanced: compare a read-only view with an independent immutable copy. */
public class Collection12UnmodifiableViewAndCopy {
    public static void main(String[] args) {
        Collection<String> source = new ArrayList<>(List.of("tea", "coffee"));
        Collection<String> view = Collections.unmodifiableCollection(source);
        List<String> copy = List.copyOf(source);

        source.add("water");
        System.out.println("View reflects source changes: " + view);
        System.out.println("Copy remains unchanged: " + copy);

        try {
            view.add("juice");
        } catch (UnsupportedOperationException exception) {
            System.out.println("The unmodifiable view rejects changes.");
        }
    }
}