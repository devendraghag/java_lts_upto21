package com.example.example.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/** Uses {@code var} locals while demonstrating VarHandle.compareAndExchange. */
public class VarHandle05VarCompareAndExchange {
    private static final VarHandle VALUE;

    static {
        try {
            VALUE = MethodHandles.lookup()
                    .findVarHandle(Counter.class, "value", int.class);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    private static final class Counter {
        private int value = 10;
    }

    public static void main(String[] args) {
        var counter = new Counter();

        // If the value is 10, set it to 20. The method returns the value it observed.
        var observedValue = (int) VALUE.compareAndExchange(counter, 10, 20);
        System.out.println("Value observed by compareAndExchange: " + observedValue);
        System.out.println("Value after first attempt: " + (int) VALUE.get(counter));

        // The value is now 20, not 10, so this attempt does not change it.
        var observedOnMismatch = (int) VALUE.compareAndExchange(counter, 10, 30);
        System.out.println("Value observed on mismatch: " + observedOnMismatch);
        System.out.println("Final value: " + (int) VALUE.get(counter));
    }
}
