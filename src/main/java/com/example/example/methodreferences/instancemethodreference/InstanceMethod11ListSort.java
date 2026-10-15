package com.example.methodreferences.instancemethodreference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Harder: Comparator can be an instance method on a specific sorting policy object. */
public class InstanceMethod11ListSort {
    static class LengthSorter {
        int compare(String left, String right) {
            return Integer.compare(left.length(), right.length());
        }
    }

    public static void main(String[] args) {
        LengthSorter sorter = new LengthSorter();
        Comparator<String> lambda = (left, right) -> sorter.compare(left, right);
        Comparator<String> reference = sorter::compare;
        List<String> words = new ArrayList<>(List.of("elephant", "cat", "tiger", "ox"));

        words.sort(lambda);
        System.out.println("Lambda: " + words);
        words = new ArrayList<>(List.of("elephant", "cat", "tiger", "ox"));
        words.sort(reference);
        System.out.println("Reference: " + words);
    }
}
