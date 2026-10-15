package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

import java.io.IOException;

/** EASY 7/17: Each method either catches a checked exception or declares it. */
public class ExceptionHandling07CheckedPropagation {
    private static void readFromDevice() throws IOException {
        throw new IOException("Device is unavailable");
    }

    // This method does not catch IOException, so it declares it too.
    private static void loadData() throws IOException {
        readFromDevice();
    }

    public static void main(String[] args) {
        try {
            loadData();
        } catch (IOException exception) {
            System.out.println("Handled at the application boundary: "
                    + exception.getMessage());
        }
    }
}
