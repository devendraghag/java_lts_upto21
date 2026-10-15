package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator26ThenComparingDouble {
    record Hotel(String city, double rating, String name) {}

    public static void main(String[] args) {
        List<Hotel> hotels = List.of(
                new Hotel("Oslo", 4.5, "North"),
                new Hotel("Oslo", 4.9, "Central"),
                new Hotel("Lima", 4.7, "Plaza"));

        Comparator<Hotel> order = Comparator.comparing(Hotel::city)
                .thenComparingDouble(Hotel::rating)
                .thenComparing(Hotel::name);
        System.out.println(hotels.stream().sorted(order).toList());
    }
}
