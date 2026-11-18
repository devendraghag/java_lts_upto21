package com.example.example.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/** Demonstrates Java's local-variable {@code var} with VarHandle field access. */
public class VarHandle04VarLocalVariables {
    private static final VarHandle VALUE;

    static {
        try {
            // var infers that valueHandle has type VarHandle.
            var valueHandle = MethodHandles.lookup()
                    .findVarHandle(Counter.class, "value", int.class);
            VALUE = valueHandle;
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    private static final class Counter {
        // Fields still need an explicit declared type; var is only for local variables.
        private int value = 5;
    }

    public static void main(String[] args) {
        var counter = new Counter(); // Inferred type: Counter
        var startingValue = (int) VALUE.get(counter); // Inferred type: int
        System.out.println("Starting value: " + startingValue);

        VALUE.set(counter, 15);
        var updatedValue = (int) VALUE.get(counter);
        System.out.println("Updated value: " + updatedValue);
    }
}
