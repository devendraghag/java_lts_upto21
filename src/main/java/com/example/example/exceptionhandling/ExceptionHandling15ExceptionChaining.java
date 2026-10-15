package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** HARD 15/17: Wrap a low-level cause in a meaningful higher-level exception. */
class ConfigurationException extends Exception {
    private static final long serialVersionUID = 1L;

    ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class ExceptionHandling15ExceptionChaining {
    private static int readPort(String text) throws ConfigurationException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException cause) {
            throw new ConfigurationException("The configured port is not a number.", cause);
        }
    }

    public static void main(String[] args) {
        try {
            readPort("http");
        } catch (ConfigurationException exception) {
            System.out.println("Application message: " + exception.getMessage());
            System.out.println("Original cause: " + exception.getCause());
        }
    }
}
