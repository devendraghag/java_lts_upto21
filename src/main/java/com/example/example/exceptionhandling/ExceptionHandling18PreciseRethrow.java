package com.example.example.exceptionhandling;

import java.io.IOException;
import java.sql.SQLException;

/** HARD 18: demonstrate Java's precise-rethrow analysis for an effectively final catch parameter. */
public class ExceptionHandling18PreciseRethrow {
    private static void read(boolean deviceFailure) throws IOException, SQLException {
        try {
            if (deviceFailure) {
                throw new IOException("Device read failed");
            }
            throw new SQLException("Database read failed");
        } catch (Exception exception) {
            // Although the catch type is Exception, the compiler knows the try can
            // throw only IOException or SQLException here and permits this declaration.
            throw exception;
        }
    }

    public static void main(String[] args) {
        for (boolean deviceFailure : new boolean[] { true, false }) {
            try {
                read(deviceFailure);
            } catch (IOException | SQLException exception) {
                System.out.println("Rethrown type: " + exception.getClass().getSimpleName());
            }
        }
    }
}
