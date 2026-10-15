package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

import java.io.IOException;

/** MEDIUM 12/17: Multi-catch (Java 7+) handles unrelated exception types together. */
public class ExceptionHandling12MultiCatch {
    private static int readAmount(String input) throws IOException {
        if ("DEVICE_ERROR".equals(input)) {
            throw new IOException("Could not read from the device");
        }
        return Integer.parseInt(input);
    }

    public static void main(String[] args) {
        String[] inputs = { "25", "not-a-number", "DEVICE_ERROR" };

        for (String input : inputs) {
            try {
                System.out.println("Amount: " + readAmount(input));
            } catch (IOException | NumberFormatException exception) {
                System.out.println("Could not read amount: " + exception.getMessage());
            }
        }
    }
}
