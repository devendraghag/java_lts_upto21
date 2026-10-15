package com.example.methodreferences.constructorreference;

import java.util.function.Function;

/** Easy+: Person::new matches Function<String, Person> by constructor parameter type. */
public class Constructor05PersonFromName {
    record Person(String name) {
    }

    public static void main(String[] args) {
        Function<String, Person> lambda = name -> new Person(name);
        Function<String, Person> reference = Person::new;

        System.out.println(lambda.apply("Amit"));
        System.out.println(reference.apply("Priya"));
    }
}
