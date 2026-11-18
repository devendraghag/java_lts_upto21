package com.example.example.collectionclassmethods;

import java.util.Collection;
import java.util.List;

/** Shows that a Collection method can be unsupported by an unmodifiable collection. */
public class Collection15OptionalOperations {
    public static void main(String[] args) {
        Collection<String> subjects = List.of("Java", "Collections");

        System.out.println("Before add: " + subjects);

        try {
            subjects.add("Generics");
        } catch (UnsupportedOperationException exception) {
            System.out.println("add is not supported by this unmodifiable collection.");
        }

        System.out.println("After attempted add: " + subjects);
    }
}

/*
 * Collection defines methods such as add, remove, and clear, but some collections
 * do not allow changes. Calling a change method on such a collection can throw
 * UnsupportedOperationException. List.of creates an unmodifiable collection here.
 */
