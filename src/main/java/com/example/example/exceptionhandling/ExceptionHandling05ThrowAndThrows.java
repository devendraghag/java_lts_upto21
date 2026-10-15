package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

import java.io.IOException;

/** EASY 5/17: throw raises an exception; throws declares a checked exception. */
public class ExceptionHandling05ThrowAndThrows {
    private static void readSettings() throws IOException {
        // throw creates/raises the exception object.
        throw new IOException("Settings file could not be read");
    }

    public static void main(String[] args) {
        try {
            readSettings();
        } catch (IOException exception) {
            System.out.println("Handled: " + exception.getMessage());
        }
    }
}
