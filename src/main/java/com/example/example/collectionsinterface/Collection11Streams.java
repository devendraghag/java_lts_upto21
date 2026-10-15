package com.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Intermediate: build a stream pipeline from a Collection. */
public class Collection11Streams {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>(List.of("Asha", "Arun", "Mina", "Aarav"));

        List<String> aNamesInUppercase = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .toList();

        long shortNames = names.stream().filter(name -> name.length() <= 4).count();
        System.out.println("Names starting with A: " + aNamesInUppercase);
        System.out.println("Names with at most four characters: " + shortNames);
    }
}