package com.example.optionalclass;

import java.util.Optional;
import java.util.stream.Stream;

/** Demonstrates Optional APIs added in Java 9 and Java 11. */
public class OptionalModernMethodsDemo {
    private static Optional<String> preferredName(String input) {
        return Optional.ofNullable(input).filter(name -> !name.isBlank());
    }

    public static void main(String[] args) {
        Optional<String> chosen = preferredName(" ")
                .or(() -> Optional.of("guest")); // Java 9+ lazy alternate Optional.
        System.out.println(chosen.orElseThrow());

        chosen.ifPresentOrElse(
                value -> System.out.println("Value: " + value),
                () -> System.out.println("No value")); // Java 9+.

        Stream<String> names = Stream.of(
                Optional.of("Asha"), Optional.<String>empty(), Optional.of("Ravi"))
                .flatMap(Optional::stream); // Java 9+.
        names.forEach(System.out::println);
    }
}
