package com.example.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** Starts collecting stream results into common collection and string forms. */
public class Stream14CollectorsBasicsDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Ben", "Asha", "Cara");

        // Collectors.toList() collects values into a List.
        List<String> list = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("List: " + list);

        // Collectors.toSet() removes duplicate values in the resulting Set.
        Set<String> set = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println("Set: " + set);

        // joining() combines text values into one String.
        String joined = names.stream()
                .collect(Collectors.joining(" | ", "[", "]"));
        System.out.println("Joined: " + joined);

        // Stream.toList() (Java 16+) returns an unmodifiable list.
        List<String> unmodifiable = names.stream().toList();
        System.out.println("Stream.toList(): " + unmodifiable);
    }
}