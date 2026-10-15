package com.example.collectionconversions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** The general Collection-to-List patterns also work for List, Set, and Map views. */
public class CollectionToListDemo {
    public static void main(String[] args) {
        Collection<String> listSource = List.of("Java", "SQL");
        Collection<String> setSource = new LinkedHashSet<>(List.of("Spring", "Docker"));

        List<String> mutableFromList = new ArrayList<>(listSource);
        List<String> mutableFromSet = new ArrayList<>(setSource);
        List<String> immutableFromList = List.copyOf(listSource);

        System.out.println("Mutable list copied from List: " + mutableFromList);
        System.out.println("Mutable list copied from Set: " + mutableFromSet);
        System.out.println("Immutable list copied from Collection: " + immutableFromList);

        // Map keySet(), values(), and entrySet() are also Collections; see MapToCollectionsDemo.
        Set<String> exampleSet = new LinkedHashSet<>(List.of("A", "B"));
        List<String> listFromSet = new ArrayList<>(exampleSet);
        System.out.println("List copied from Set: " + listFromSet);
    }
}