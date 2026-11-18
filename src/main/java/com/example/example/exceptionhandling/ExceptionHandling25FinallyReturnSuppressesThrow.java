package com.example.example.exceptionhandling;

import java.io.IOException;

/** HARD 25: a return in finally suppresses an exception thrown by try. */
public class ExceptionHandling25FinallyReturnSuppressesThrow {
    @SuppressWarnings("finally")
    private static String load() throws IOException {
        try {
            throw new IOException("File read failed");
        } finally {
            // Bad practice: this return discards the IOException.
            return "fallback from finally";
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Result: " + load());
        } catch (IOException exception) {
            System.out.println("This catch is not reached: " + exception);
        }
    }
}
