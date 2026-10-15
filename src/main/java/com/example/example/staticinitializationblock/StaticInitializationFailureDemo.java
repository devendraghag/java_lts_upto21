package com.example.staticinitializationblock;

/** Demonstrates failures during class initialization and subsequent class use. */
public class StaticInitializationFailureDemo {
    private static final class BrokenConfiguration {
        static {
            if (shouldFail()) {
                throw new IllegalStateException("Invalid static configuration");
            }
        }

        private static boolean shouldFail() {
            return true;
        }

        private static int value() {
            return 1;
        }
    }

    public static void main(String[] args) {
        try {
            BrokenConfiguration.value();
        } catch (ExceptionInInitializerError error) {
            System.out.println("First active use failed: " + error.getCause());
        }

        try {
            BrokenConfiguration.value();
        } catch (NoClassDefFoundError error) {
            System.out.println("Later use fails because initialization did not complete");
        }
    }
}
