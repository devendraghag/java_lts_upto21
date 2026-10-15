package com.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Beginner: clear removes every element from a mutable collection. */
public class Collection05Clear {
    public static void main(String[] args) {
        Collection<String> tasks = new ArrayList<>(List.of("read", "practice", "review"));
        System.out.println("Before clear: " + tasks);
        tasks.clear();
        System.out.println("After clear: " + tasks);
        System.out.println("Empty now: " + tasks.isEmpty());
    }
}