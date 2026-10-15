package com.example.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors08AveragingInt {
    public static void main(String[] args) {
        List<Integer> scores = List.of(70, 85, 95);

        double average = scores.stream()
                .collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("average score = " + average);
    }
}
