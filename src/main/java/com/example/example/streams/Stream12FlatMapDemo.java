package com.example.streams;

import java.util.List;

/** Demonstrates flattening nested collections with flatMap(). */
public class Stream12FlatMapDemo {
    public static void main(String[] args) {
        List<List<String>> teams = List.of(
                List.of("Asha", "Leo"),
                List.of("Mina", "Noah", "Omar"));

        // Each team is a stream of names. flatMap() combines those small streams
        // into one stream containing every name.
        List<String> allMembers = teams.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("All team members: " + allMembers);
    }
}