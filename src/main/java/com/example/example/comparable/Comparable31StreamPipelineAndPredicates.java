package com.example.comparable;

import java.util.*;

public class Comparable31StreamPipelineAndPredicates {
    record Word(String value) implements Comparable<Word> {
        public int compareTo(Word o) {
            return value.compareTo(o.value);
        }
    }

    public static void main(String[] x) {
        List<Word> w = List.of(new Word("pear"), new Word("apple"), new Word("plum"));
        List<String> result = w.stream()
                .sorted()
                .filter(a -> a.compareTo(new Word("pear")) < 0)
                .map(Word::value)
                .toList();
        System.out.println(result);
        System.out.println(w.stream().allMatch(a -> a.compareTo(new Word("apple")) >= 0));
        System.out.println(w.stream().anyMatch(a -> a.compareTo(new Word("plum")) == 0));
        System.out.println(w.stream().noneMatch(a -> a.compareTo(new Word("aaa")) < 0));
        // compareTo drives natural checks.
    }
}
