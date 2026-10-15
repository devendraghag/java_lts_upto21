package com.example.variables;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/** Level 13: Demonstrates resource variables and exception parameters. */
public class Variable13ResourceAndExceptionDemo {
    public static void main(String[] args) {
        byte[] data = "read with a resource variable".getBytes(StandardCharsets.UTF_8);

        try (InputStream input = new ByteArrayInputStream(data)) {
            byte[] result = input.readAllBytes();
            System.out.println(new String(result, StandardCharsets.UTF_8));
        } catch (IOException exception) { // Catch parameter is scoped to this catch block.
            System.out.println("Read failed: " + exception.getMessage());
        }
    }
}
