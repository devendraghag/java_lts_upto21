package com.example.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Explains the ?, and c in Collection.removeAll(Collection<?> c). */
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
 * removeAll(Collection<?> c)
 *
 * ? = a placeholder meaning the other collection can have any item type.
 * c = the parameter name for the collection passed to removeAll.
 *
 * In simple words: remove from this collection every item also found in c.
 * The wildcard does not mean removeAll adds those items; it only uses c to find matches.
 */
