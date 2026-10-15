package com.example.intermediateoperations;

import java.util.List;
import java.util.stream.IntStream;

/** Medium: skip and limit select a page from an ordered stream. */
public class IntermediatePractice08LimitAndSkip {
    public static void main(String[] args) {
        List<Integer> values = IntStream.rangeClosed(1, 20).boxed().toList();
        int pageNumber = 2;
        int pageSize = 5;
        List<Integer> page = values.stream()
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .toList();
        System.out.println("Page " + pageNumber + ": " + page);
    }
}