package com.example.example.exceptionhandling;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

/** HARD 21: adapt a checked exception when calling a method from a stream lambda. */
public class ExceptionHandling21LambdaStreamExceptions {
    private static String readValue(String value) throws IOException {
        if ("BROKEN".equals(value)) {
            throw new IOException("Could not read value");
        }
        return value.toUpperCase();
    }

    private static String readValueForStream(String value) {
        try {
            return readValue(value);
        } catch (IOException exception) {
            // Function<T,R> used by map cannot declare a checked exception.
            throw new UncheckedIOException("Stream item failed: " + value, exception);
        }
    }

    public static void main(String[] args) {
        List<String> input = List.of("first", "BROKEN", "last");

        try {
            // Stream operations are lazy; the failure is raised during toList().
            List<String> result = input.stream()
                    .map(ExceptionHandling21LambdaStreamExceptions::readValueForStream)
                    .toList();
            System.out.println(result);
        } catch (UncheckedIOException exception) {
            System.out.println("Stream failed: " + exception.getMessage());
            System.out.println("Original cause: " + exception.getCause());
        }
    }
}
