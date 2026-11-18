package com.example.example.intermediateoperations;

import java.util.List;

/** mapToDouble transforms objects into primitive double values (a DoubleStream). */
public class IntermediateOperation06MapToDouble {
    public static void main(String[] args) {
        List<String> prices = List.of("12.50", "7.25", "3.00");

        double total = prices.stream()
                .mapToDouble(Double::parseDouble)
                .sum();

        System.out.println("Total price: " + total);
    }
}
