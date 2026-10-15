package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;

/** Beginner: inspect a collection with size and isEmpty. */
public class Collection02SizeAndIsEmpty {
    public static void main(String[] args) {
        Collection<Integer> scores = new ArrayList<>();
        System.out.println("Initially empty: " + scores.isEmpty());
        scores.add(85);
        scores.add(92);
        scores.add(78);
        System.out.println("Number of scores: " + scores.size());
        System.out.println("Empty after adding scores: " + scores.isEmpty());
    }
}