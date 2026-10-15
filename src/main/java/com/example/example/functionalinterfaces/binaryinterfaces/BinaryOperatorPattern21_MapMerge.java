package com.example.functionalinterfaces.binaryinterfaces;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/** Pattern 21: Map.merge uses a BinaryOperator to combine an old and new value. */
public class BinaryOperatorPattern21_MapMerge {
    public static void main(String[] args) {
        Map<String, Integer> wordCounts = new LinkedHashMap<>();
        BinaryOperator<Integer> addCounts = Integer::sum;

        wordCounts.merge("java", 1, addCounts);
        wordCounts.merge("java", 1, addCounts);
        wordCounts.merge("sql", 1, addCounts);
        System.out.println(wordCounts);
    }
}