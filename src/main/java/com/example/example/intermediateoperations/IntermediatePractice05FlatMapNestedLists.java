package com.example.intermediateoperations;

import java.util.List;

/** Medium: flatMap turns a stream of lists into one stream of their elements. */
public class IntermediatePractice05FlatMapNestedLists {
    public static void main(String[] args) {
        List<List<String>> teams = List.of(List.of("Asha", "Dev"), List.of("Mina"), List.of("Ravi", "Noor"));
        List<String> members = teams.stream().flatMap(List::stream).map(String::toUpperCase).toList();
        System.out.println(members);
    }
}