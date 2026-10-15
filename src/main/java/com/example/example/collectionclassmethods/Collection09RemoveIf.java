package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Intermediate: removeIf deletes every element matching a predicate. */
public class Collection09RemoveIf {
    public static void main(String[] args) {
        Collection<String> words = new ArrayList<>(List.of("map", "collection", "set", "iterator"));
        boolean changed = words.removeIf(word -> word.length() > 4);

        System.out.println("Any words removed: " + changed);
        System.out.println("Words of at most four letters: " + words);
    }
}