package com.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Explains Collection.removeAll(Collection<?> c). */
public class Collection14RemoveAllWildcard {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>(List.of("Asha", "Ravi", "Mina"));
        Collection<String> namesToRemove = List.of("Ravi");

        boolean changed = names.removeAll(namesToRemove);
        System.out.println("Names left: " + names);
        System.out.println("Did names change? " + changed);
    }
}

/*
 * ? means the collection passed to removeAll can contain any item type.
 * c is the parameter name for that collection; here c is namesToRemove.
 *
 * In simple words: remove from this collection every item also found in c.
 */
