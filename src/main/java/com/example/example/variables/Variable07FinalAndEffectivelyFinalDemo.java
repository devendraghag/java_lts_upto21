package com.example.variables;

/** Level 07: Demonstrates final variables, blank final fields, and effectively final locals. */
public class Variable07FinalAndEffectivelyFinalDemo {
    private static final String APPLICATION_NAME = "VariableExamples";

    private static final class User {
        private final String name; // Blank final field, assigned by the constructor.

        private User(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        final int maximumAttempts = 3;
        int attempts = 1; // Effectively final because it is never reassigned.

        Runnable report = () -> System.out.println(
                APPLICATION_NAME + ": " + attempts + " of " + maximumAttempts);
        report.run();

        User user = new User("Maya");
        System.out.println("User=" + user.name);
        // A final reference cannot be reassigned, but a referenced mutable object may still change.
    }
}
