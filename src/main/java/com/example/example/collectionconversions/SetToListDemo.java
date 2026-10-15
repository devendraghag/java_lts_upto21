package com.example.collectionconversions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Set to mutable or immutable List conversion. */
public class SetToListDemo {
    public static void main(String[] args) {
        Set<String> courses = new LinkedHashSet<>(List.of("Java", "Spring", "SQL"));

        List<String> mutableList = new ArrayList<>(courses);
        mutableList.add("Docker");
        List<String> immutableList = List.copyOf(courses);

        System.out.println("Set: " + courses);
        System.out.println("Mutable list: " + mutableList);
        System.out.println("Immutable list: " + immutableList);
    }
}