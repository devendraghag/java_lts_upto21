package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

import java.io.IOException;

/** HARD 14/17: A try-with-resources failure can be suppressed behind a primary failure. */
public class ExceptionHandling14SuppressedExceptions {
    static class FailingResource implements AutoCloseable {
        private final String name;

        FailingResource(String name) {
            this.name = name;
        }

        @Override
        public void close() throws IOException {
            System.out.println("Closing " + name);
            throw new IOException(name + " could not close");
        }
    }

    public static void main(String[] args) {
        try (FailingResource first = new FailingResource("first");
             FailingResource second = new FailingResource("second")) {
            throw new IOException("Work failed");
        } catch (IOException exception) {
            System.out.println("Primary exception: " + exception.getMessage());
            for (Throwable suppressed : exception.getSuppressed()) {
                System.out.println("Suppressed exception: " + suppressed.getMessage());
            }
        }
    }
}
