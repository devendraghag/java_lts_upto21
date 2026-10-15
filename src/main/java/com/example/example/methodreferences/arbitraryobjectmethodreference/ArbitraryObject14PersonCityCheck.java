package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.BiPredicate;

/** Harder: a Person receiver plus a city argument matches BiPredicate<Person, String>. */
public class ArbitraryObject14PersonCityCheck {
    record Person(String name, String city) {
        boolean livesIn(String requestedCity) {
            return city.equalsIgnoreCase(requestedCity);
        }
    }

    public static void main(String[] args) {
        BiPredicate<Person, String> lambda = (person, city) -> person.livesIn(city);
        BiPredicate<Person, String> reference = Person::livesIn;
        Person person = new Person("Sara", "Mumbai");

        System.out.println(lambda.test(person, "MUMBAI"));
        System.out.println(reference.test(person, "Delhi"));
    }
}
