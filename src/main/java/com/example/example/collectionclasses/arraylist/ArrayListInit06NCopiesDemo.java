package com.example.collectionclasses.arraylist;

import java.util.ArrayList;
import java.util.Collections;

/** Article approach 6: initialize with repeated values using nCopies(). */
public class ArrayListInit06NCopiesDemo {
    public static void main(String[] args) {
        // nCopies returns a fixed-size list containing the same value repeatedly.
        // Copy it into an ArrayList to get a resizable list.
        ArrayList<Integer> scores = new ArrayList<>(Collections.nCopies(5, 10));

        scores.set(0, 20);
        scores.add(15);

        System.out.println("Scores: " + scores);
    }
}