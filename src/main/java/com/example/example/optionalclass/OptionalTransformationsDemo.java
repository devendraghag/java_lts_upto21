package com.example.optionalclass;

import java.util.Optional;

/** Demonstrates filter, map, and flatMap. */
public class OptionalTransformationsDemo {
    private record User(String email) {
    }

    private static Optional<User> findUser(String username) {
        return username.equals("asha")
                ? Optional.of(new User("asha@example.com"))
                : Optional.empty();
    }

    private static Optional<String> findEmail(String username) {
        return findUser(username).map(User::email);
    }

    private static Optional<String> findDomain(String username) {
        return findUser(username)
                .flatMap(user -> Optional.ofNullable(user.email()))
                .map(email -> email.substring(email.indexOf('@') + 1))
                .filter(domain -> domain.contains("."));
    }

    public static void main(String[] args) {
        System.out.println(findEmail("asha").orElse("No email"));
        System.out.println(findDomain("asha").orElse("No domain"));
        System.out.println(findEmail("unknown").orElse("No email"));
    }
}
