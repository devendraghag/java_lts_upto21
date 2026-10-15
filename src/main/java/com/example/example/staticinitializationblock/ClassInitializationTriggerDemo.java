package com.example.staticinitializationblock;

/** Demonstrates when a class is initialized by active use. */
public class ClassInitializationTriggerDemo {
    private static final class Registry {
        static {
            System.out.println("Registry class initialized");
        }

        private static final int COMPILE_TIME_CONSTANT = 21;
        private static final Integer BOXED_VALUE = 21;

        private static int value() {
            return 7;
        }
    }

    public static void main(String[] args) {
        System.out.println("Class literal: " + Registry.class.getSimpleName());
        System.out.println("Compile-time constant: " + Registry.COMPILE_TIME_CONSTANT);
        System.out.println("The Registry initializer has not run yet");

        System.out.println("Boxed static field: " + Registry.BOXED_VALUE);
        System.out.println("Static method result: " + Registry.value());
    }
}
