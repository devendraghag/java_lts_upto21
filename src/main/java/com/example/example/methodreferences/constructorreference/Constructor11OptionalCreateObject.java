package com.example.methodreferences.constructorreference;

import java.util.Optional;
import java.util.function.Function;

/** Medium: Optional.map's Function can refer to a one-argument constructor. */
public class Constructor11OptionalCreateObject {
    record EmailAddress(String value) {
    }

    public static void main(String[] args) {
        Function<String, EmailAddress> lambda = value -> new EmailAddress(value);
        Function<String, EmailAddress> reference = EmailAddress::new;
        Optional<String> rawEmail = Optional.of("learner@example.com");

        System.out.println("Lambda: " + lambda.apply("a@example.com"));
        System.out.println("Optional: " + rawEmail.map(reference));
    }
}
