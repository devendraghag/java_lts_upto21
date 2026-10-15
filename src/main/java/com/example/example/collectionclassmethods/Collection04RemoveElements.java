package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Beginner: remove one matching element by value. */
public class Collection04RemoveElements {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>(List.of("Asha", "Ravi", "Asha", "Mina"));

        System.out.println("Before: " + names);
        System.out.println("Removed Asha: " + names.remove("Asha"));
        System.out.println("After one removal: " + names);
        System.out.println("Removed Zoya: " + names.remove("Zoya"));
    }
}