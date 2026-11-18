package com.example.example.exceptionhandling;

/** HARD 26: a throw in finally replaces a pending return from try. */
public class ExceptionHandling26FinallyThrowOverridesReturn {
    private static int calculate() {
        try {
            return 42;
        } finally {
            throw new IllegalStateException("Finally failed before return completed");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Result: " + calculate());
        } catch (IllegalStateException exception) {
            System.out.println("Return was replaced: " + exception.getMessage());
        }
    }
}
