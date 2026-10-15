package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator54StreamSortedComparing {
    record Person(String name, String city) {}

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Mira", "Oslo"),
                new Person("Asha", "Delhi"),
                new Person("Bo", "Delhi"));
        System.out.println(people.stream()
                .sorted(Comparator.comparing(Person::city).thenComparing(Person::name))
                .toList());
    }
}
