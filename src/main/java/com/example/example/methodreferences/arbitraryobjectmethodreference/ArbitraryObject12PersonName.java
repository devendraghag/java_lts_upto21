package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.Function;

/** Medium+: a user-defined receiver works the same way as String. */
public class ArbitraryObject12PersonName {
    record Person(String name, int age) {
        String nameInUpperCase() {
            return name.toUpperCase();
        }
    }

    public static void main(String[] args) {
        Function<Person, String> lambda = person -> person.nameInUpperCase();
        Function<Person, String> reference = Person::nameInUpperCase;
        Person person = new Person("Amit", 28);

        System.out.println(lambda.apply(person));
        System.out.println(reference.apply(person));
    }
}
