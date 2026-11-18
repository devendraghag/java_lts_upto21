package com.example.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** {@code removeIf(filter)} removes every item for which the given test returns true. */
public class Collection09RemoveIf {
    public static void main(String[] args) {
        Collection<String> words = new ArrayList<>(List.of("map", "collection", "set", "iterator"));
        boolean changed = words.removeIf(word -> word.length() > 4);

        System.out.println("Any words removed: " + changed);
        System.out.println("Words of at most four letters: " + words);
    }
}
