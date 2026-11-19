package com.example.example.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors07SummingInt {
    public static void main(String[] args) {
        List<Integer> prices = List.of(120, 80, 50);

        int total = prices.stream()
                .collect(Collectors.summingInt(Integer::intValue));

//        int total = prices.stream()
//                .mapToInt(Integer::intValue)
//                .sum();


//        int total = prices.stream()
//                .collect(Collectors.summingInt(price -> price));

        System.out.println("total price = " + total);
    }
}
