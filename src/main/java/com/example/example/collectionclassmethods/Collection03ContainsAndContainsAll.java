package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Beginner: search for one element or for all elements in another collection. */
public class Collection03ContainsAndContainsAll {
    public static void main(String[] args) {
        Collection<String> pantry = new ArrayList<>(List.of("rice", "beans", "oil", "salt"));

        System.out.println("Has beans: " + pantry.contains("beans"));
        System.out.println("Has sugar: " + pantry.contains("sugar"));
        System.out.println("Has rice and oil: " + pantry.containsAll(List.of("rice", "oil")));
        System.out.println("Has rice and tea: " + pantry.containsAll(List.of("rice", "tea")));
    }
}