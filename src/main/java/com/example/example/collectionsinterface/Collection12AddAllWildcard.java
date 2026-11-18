package com.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Explains Collection.addAll(Collection<? extends E> c). */
public class Collection12AddAllWildcard {
    public static void main(String[] args) {
        Collection<Number> destination = new ArrayList<>();
        Collection<Integer> source = List.of(10, 20);

        boolean changed = destination.addAll(source);
        System.out.println("Items in destination: " + destination);
        System.out.println("Did destination change? " + changed);
    }
}

/*
 * E is the destination's item type. Here E is Number.
 * ? is a placeholder for the source's item type.
 * ? extends E means the source items can be E or a subtype of E.
 * c is the parameter name for the collection passed to addAll. Here c is source.
 *
 * In simple words: add every item from c into this collection if its item type fits E.
 */
