package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/*
 * JDK 1.0 introduction-version bucket interview program: method overriding.
 *
 * Interview point:
 * - Overriding is runtime polymorphism.
 * - The object type decides which overridden method executes.
 */
/**
 * Easy: Demonstrates Method Overriding Interview Program in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
public class MethodOverridingInterviewProgram {
    public static void main(String[] args) {
        AnimalInterview animal = new DogInterview();
        check("bark".equals(animal.sound()), "Override mismatch");
        System.out.println(animal.sound());
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new IllegalStateException(message);
    }
}

class AnimalInterview {
    String sound() {
        return "sound";
    }
}

class DogInterview extends AnimalInterview {
    @Override
    String sound() {
        return "bark";
    }
}
