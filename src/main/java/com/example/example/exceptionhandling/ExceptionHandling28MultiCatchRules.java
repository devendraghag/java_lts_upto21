package com.example.example.exceptionhandling;

import java.io.IOException;
import java.sql.SQLException;

/** HARD 28: multi-catch alternatives must be unrelated, and its parameter cannot be reassigned. */
public class ExceptionHandling28MultiCatchRules {
    private static void read(boolean useDevice) throws IOException, SQLException {
        if (useDevice) {
            throw new IOException("Device failed");
        }
        throw new SQLException("Database failed");
    }

    public static void main(String[] args) {
        for (boolean useDevice : new boolean[] { true, false }) {
            try {
                read(useDevice);
            } catch (IOException | SQLException exception) {
                // A multi-catch parameter is implicitly final.
                // exception = new IOException(); // Compile-time error.
                System.out.println("Handled " + exception.getClass().getSimpleName());
            }
        }
    }
}
