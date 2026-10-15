package com.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Explains how to handle duplicate keys while collecting into a Map. */
public class Stream16CollectorsToMapMergeDemo {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Asha", 120),
                new Order("Ben", 80),
                new Order("Asha", 45));

        // Without a merge function, duplicate customer names would cause
        // Collectors.toMap() to throw IllegalStateException.
        // The merge function below adds amounts for orders with the same customer.
        Map<String, Integer> totalByCustomer = orders.stream()
                .collect(Collectors.toMap(
                        Order::customer,
                        Order::amount,
                        Integer::sum));

        System.out.println("Total amount by customer: " + totalByCustomer);
    }

    private record Order(String customer, int amount) {
    }
}