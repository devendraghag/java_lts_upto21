package com.example.objectinitialization;

/** Demonstrates a static factory method that controls object creation. */
public class StaticFactoryInitializationDemo {
    private static final class User {
        private final String username;

        private User(String username) {
            this.username = username;
        }

        private static User guest() {
            return new User("guest");
        }

        private static User named(String username) {
            if (username == null || username.isBlank()) {
                throw new IllegalArgumentException("Username must not be blank");
            }
            return new User(username.trim());
        }

        @Override
        public String toString() {
            return "User(" + username + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println(User.guest());
        System.out.println(User.named("  maya  "));
    }
}
