package com.example.varargs;

/** Level 2: put required fixed parameters before the final varargs parameter. */
public class Varargs02FixedAndVariableParametersDemo {
    public static void main(String[] args) {
        log("INFO"); // Required level, with no messages.
        log("WARN", "Low disk space", "Cleanup recommended");

        String[] messages = {"Connected", "Ready"};
        log("DEBUG", messages); // The whole array supplies the variable arguments.
    }

    // A varargs parameter must always be the last parameter in the method declaration.
    private static void log(String level, String... messages) {
        if (messages.length == 0) {
            System.out.println(level + ": no messages");
            return;
        }
        for (String message : messages) {
            System.out.println(level + ": " + message);
        }
    }
}
