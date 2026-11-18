package com.example.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** {@code contains(o)} checks one item; {@code containsAll(c)} checks all items from c. */
public class Collection03ContainsAndContainsAll {
    public static void main(String[] args) {
        Collection<String> pantry = new ArrayList<>(List.of("rice", "beans", "oil", "salt"));

        System.out.println("Has beans: " + pantry.contains("beans"));
        System.out.println("Has sugar: " + pantry.contains("sugar"));
        System.out.println("Has rice and oil: " + pantry.containsAll(List.of("rice", "oil")));
        System.out.println("Has rice and tea: " + pantry.containsAll(List.of("rice", "tea")));
    }
}
