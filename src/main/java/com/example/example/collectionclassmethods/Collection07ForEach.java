package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Intermediate: process each element with a loop, lambda, or method reference. */
public class Collection07ForEach {
    public static void main(String[] args) {
        Collection<String> tools = new ArrayList<>(List.of("compiler", "debugger", "formatter"));

        System.out.println("Enhanced for loop:");
        for (String tool : tools) {
            System.out.println(tool);
        }

        System.out.println("forEach with lambda:");
        tools.forEach(tool -> System.out.println("Tool: " + tool));

        System.out.println("forEach with method reference:");
        tools.forEach(System.out::println);
    }
}