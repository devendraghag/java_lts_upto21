package com.example.example.exceptionhandling;

/** HARD 23: compare swallowing an exception and dropping its cause with preserving the cause. */
public class ExceptionHandling23SwallowingAndCauseLoss {
    private static int parseBadly(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            // Bad: the failure is hidden and the caller cannot tell parsing failed.
            return -1;
        }
    }

    private static int parseAndLoseCause(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            // Bad: a new exception is thrown, but the original cause is discarded.
            throw new IllegalArgumentException("Invalid number: " + text);
        }
    }

    private static int parseAndPreserveCause(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Invalid number: " + text, exception);
        }
    }

    public static void main(String[] args) {
        System.out.println("Swallowed failure returns: " + parseBadly("abc"));

        try {
            parseAndLoseCause("abc");
        } catch (IllegalArgumentException exception) {
            System.out.println("Cause after bad wrapping: " + exception.getCause());
        }

        try {
            parseAndPreserveCause("abc");
        } catch (IllegalArgumentException exception) {
            System.out.println("Cause after good wrapping: " + exception.getCause());
        }
    }
}
