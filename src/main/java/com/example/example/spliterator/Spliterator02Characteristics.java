package com.example.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Spliterator;
import java.util.TreeSet;

/**
 * {@code characteristics()} is a bitmask describing structural guarantees a source can make
 * (ORDERED, SIZED, DISTINCT, SORTED, ...); the stream pipeline uses it to pick faster
 * algorithms. Different collections advertise different bits even though all three are
 * "just" collections of the same elements.
 * <p>Output: {@code ArrayList ORDERED=true SORTED=false}, {@code HashSet DISTINCT=true
 * ORDERED=false}, {@code TreeSet SORTED=true DISTINCT=true}.
 */
public class Spliterator02Characteristics {
    public static void main(String[] args) {
        Spliterator<Integer> arrayListSpliterator = new ArrayList<>(List.of(3, 1, 2)).spliterator();
        Spliterator<Integer> hashSetSpliterator = new HashSet<>(List.of(3, 1, 2)).spliterator();
        Spliterator<Integer> treeSetSpliterator = new TreeSet<>(List.of(3, 1, 2)).spliterator();

        System.out.println("ArrayList ORDERED=" + arrayListSpliterator.hasCharacteristics(Spliterator.ORDERED)
                + " SORTED=" + arrayListSpliterator.hasCharacteristics(Spliterator.SORTED));
        System.out.println("HashSet DISTINCT=" + hashSetSpliterator.hasCharacteristics(Spliterator.DISTINCT)
                + " ORDERED=" + hashSetSpliterator.hasCharacteristics(Spliterator.ORDERED));
        System.out.println("TreeSet SORTED=" + treeSetSpliterator.hasCharacteristics(Spliterator.SORTED)
                + " DISTINCT=" + treeSetSpliterator.hasCharacteristics(Spliterator.DISTINCT));
    }
}
