package com.example.example.exceptionhandling;

/** HARD 20: log an exception object to retain its stack trace; avoid logging it at every layer. */
public class ExceptionHandling20StackTraceLogging {
    private static final System.Logger LOGGER =
            System.getLogger(ExceptionHandling20StackTraceLogging.class.getName());

    private static void loadConfiguration() {
        try {
            throw new IllegalArgumentException("Port must be a number");
        } catch (IllegalArgumentException exception) {
            // Passing the exception to the logger includes its stack trace.
            LOGGER.log(System.Logger.Level.ERROR, "Could not load configuration", exception);
        }
    }

    public static void main(String[] args) {
        loadConfiguration();
        System.out.println("The failure was logged with its exception and stack trace.");
    }
}
