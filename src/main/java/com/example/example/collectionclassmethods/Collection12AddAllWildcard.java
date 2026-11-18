package com.example.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Explains the E, ?, and c in Collection.addAll(Collection<? extends E> c). */
public class Collection12AddAllWildcard {
    public static void main(String[] args) {
        Collection<Number> destination = new ArrayList<>();
        Collection<Integer> source = List.of(10, 20);

        boolean changed = destination.addAll(source);

        System.out.println("Destination items: " + destination);
        System.out.println("Did destination change? " + changed);
    }
}

/*
 * addAll(Collection<? extends E> c)
 *
 * E = the item type of the collection receiving the items. Here E is Number.
 * ? = a placeholder for the source collection's item type. It can be E or a subtype of E.
 * extends E = the source items must be E or a subtype of E. Here Integer is a subtype of Number.
 * c = the parameter name for the collection passed to addAll. Here c refers to source.
 *
 * In simple words: add all items from c when they fit the destination's item type E.
 */
