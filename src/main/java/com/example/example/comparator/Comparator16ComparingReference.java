package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator16ComparingReference {
    record City(String name, String country) {}

    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("Delhi", "India"),
                new City("Oslo", "Norway"),
                new City("Mumbai", "India"));

        // comparing extracts a reference key; this overload accepts a comparator for that key.
        Comparator<City> byCountryThenCity = Comparator
                .comparing(City::country, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(City::name);
        System.out.println(cities.stream().sorted(byCountryThenCity).toList());
    }
}
