package com.example.example.exceptionhandling;

import java.io.IOException;

/** HARD 19: a throw from finally replaces an exception already thrown by try. */
public class ExceptionHandling19FinallyThrowPitfall {
    private static void performWork() throws IOException {
        try {
            throw new IOException("Original work failure");
        } finally {
            // Bad practice: this exception replaces the IOException from the try block.
            throw new IllegalStateException("Cleanup failure from finally");
        }
    }

    public static void main(String[] args) {
        try {
            performWork();
        } catch (Exception exception) {
            System.out.println("Exception observed by caller: "
                    + exception.getClass().getSimpleName() + ": " + exception.getMessage());
            System.out.println("Cause: " + exception.getCause());
        }
    }
}
