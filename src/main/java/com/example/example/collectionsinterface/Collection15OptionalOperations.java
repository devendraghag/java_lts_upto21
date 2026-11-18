package com.example.example.collectionsinterface;

import java.util.Collection;
import java.util.List;

/** Shows what happens when a Collection implementation does not support adding items. */
public class Collection15OptionalOperations {
    public static void main(String[] args) {
        Collection<String> topics = List.of("Collection", "Interface");
        System.out.println("Before add: " + topics);

        try {
            topics.add("Methods");
        } catch (UnsupportedOperationException exception) {
            System.out.println("This collection does not support add().");
        }

        System.out.println("After attempted add: " + topics);
    }
}

/*
 * Collection declares methods such as add, remove, and clear, but not every
 * collection allows changes. Calling an unsupported change method can throw
 * UnsupportedOperationException. List.of creates an unmodifiable collection here.
 */
