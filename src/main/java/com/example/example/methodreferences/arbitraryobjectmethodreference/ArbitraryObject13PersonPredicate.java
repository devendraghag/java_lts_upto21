package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.List;
import java.util.function.Predicate;

/** Medium+: Person::isAdult is a Predicate<Person>: Person input -> boolean. */
public class ArbitraryObject13PersonPredicate {
    record Person(String name, int age) {
        boolean isAdult() {
            return age >= 18;
        }
    }

    public static void main(String[] args) {
        Predicate<Person> lambda = person -> person.isAdult();
        Predicate<Person> reference = Person::isAdult;
        List<Person> people = List.of(new Person("Mina", 17), new Person("Dev", 21));

        System.out.println("Lambda checks Mina: " + lambda.test(people.getFirst()));
        System.out.println("Adults: " + people.stream().filter(reference).toList());
    }
}
