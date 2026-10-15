package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator23ThenComparingComparator {
    record Person(String department, String lastName) {}

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("IT", "Aria"),
                new Person("Sales", "Brown"),
                new Person("IT", "Zoe"));

        Comparator<Person> lastNameDescending = Comparator.comparing(Person::lastName).reversed();
        // This overload adds a complete comparator as the tie-break rule.
        Comparator<Person> order = Comparator.comparing(Person::department)
                .thenComparing(lastNameDescending);
        System.out.println(people.stream().sorted(order).toList());
    }
}
