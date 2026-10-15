package com.example.comparator;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Comparator62MapEntriesByValue {
    public static void main(String[] args) {
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Asha", 91);
        scores.put("Bo", 78);
        scores.put("Mira", 91);

        Comparator<Map.Entry<String, Integer>> byScoreDescendingThenName =
                Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey());
        System.out.println(scores.entrySet().stream()
                .sorted(byScoreDescendingThenName).toList());
    }
}
