package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/** Intermediate: convert a Collection to Object[] or to a typed array. */
public class Collection10ToArray {
    public static void main(String[] args) {
        Collection<String> cities = new ArrayList<>(List.of("Delhi", "Pune", "Kochi"));

        Object[] objects = cities.toArray();
        String[] names = cities.toArray(String[]::new);

        System.out.println("Object array: " + Arrays.toString(objects));
        System.out.println("String array: " + Arrays.toString(names));
    }
}