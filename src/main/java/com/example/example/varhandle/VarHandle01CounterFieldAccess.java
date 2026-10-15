package com.example.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/** Demonstrates VarHandle operations on a counter object's field. */
public class VarHandle01CounterFieldAccess {
    private static final VarHandle VALUE;

    static {
        try {
            // Find a handle that points to Counter.value.
            VALUE = MethodHandles.lookup().findVarHandle(Counter.class, "value", int.class);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    private static final class Counter {
        // Volatile allows this example to show volatile VarHandle access modes.
        private volatile int value;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        System.out.println("Initial value: " + VALUE.getVolatile(counter));
        VALUE.setVolatile(counter, 10);

        // Atomically add five and return the previous value.
        int previous = (int) VALUE.getAndAdd(counter, 5);
        System.out.println("Previous value: " + previous);

        boolean updated = VALUE.compareAndSet(counter, 15, 20);
        System.out.println("Compare-and-set succeeded: " + updated);
        System.out.println("Current value: " + VALUE.getVolatile(counter));
    }
}
