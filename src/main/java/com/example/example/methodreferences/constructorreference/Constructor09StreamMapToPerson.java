package com.example.methodreferences.constructorreference;

import java.util.List;

/** Medium: Stream.map accepts Function<String, Person>, matching Person::new. */
public class Constructor09StreamMapToPerson {
    record Person(String name) {
    }

    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Kabir", "Meera");

        // Lambda version: .map(name -> new Person(name))
        List<Person> people = names.stream()
                .map(Person::new)
                .toList();

        System.out.println(people);
    }
}
