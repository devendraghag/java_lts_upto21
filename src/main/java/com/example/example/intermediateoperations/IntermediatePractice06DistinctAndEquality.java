package com.example.intermediateoperations;

import java.util.List;

/** Medium: distinct uses equals and hashCode; records provide value-based equality. */
public class IntermediatePractice06DistinctAndEquality {
    record Tag(String text) {}

    public static void main(String[] args) {
        List<Tag> tags = List.of(new Tag("java"), new Tag("streams"), new Tag("java"), new Tag("JDK"));
        System.out.println(tags.stream().distinct().toList());
    }
}