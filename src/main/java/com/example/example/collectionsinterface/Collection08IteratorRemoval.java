package com.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/** Intermediate: use Iterator.remove while traversing the same collection. */
public class Collection08IteratorRemoval {
    public static void main(String[] args) {
        Collection<Integer> values = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Iterator<Integer> iterator = values.iterator();

        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value % 2 == 0) {
                iterator.remove(); // Safe removal through the active iterator.
            }
        }

        System.out.println("Odd values left: " + values);
    }
}