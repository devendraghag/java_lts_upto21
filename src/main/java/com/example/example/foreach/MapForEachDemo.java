package com.example.foreach;

import java.util.LinkedHashMap;
import java.util.Map;

/** Demonstrates Map.forEach(BiConsumer). */
public class MapForEachDemo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Asha", 91);
        scores.put("Ravi", 84);
        scores.put("Mina", 96);

        scores.forEach((name, score) ->
                System.out.println(name + " scored " + score));
    }
}
