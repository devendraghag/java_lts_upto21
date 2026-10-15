package com.example.intermediateoperations;

import java.util.List;

/** Harder: mapMulti lets one input emit zero or more output elements. */
public class IntermediatePractice11MapMulti {
    public static void main(String[] args) {
        List<String> words = List.of("cat", "ox");
        List<Character> characters = words.stream()
                .<Character>mapMulti((word, downstream) -> {
                    for (char character : word.toCharArray()) {
                        downstream.accept(character);
                    }
                })
                .toList();
        System.out.println(characters);
    }
}