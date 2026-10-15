package com.example.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/** Demonstrates reading, writing, and atomically updating an array element with VarHandle. */
public class VarHandle02ArrayElementAccess {
    private static final VarHandle ELEMENT =
            MethodHandles.arrayElementVarHandle(int[].class);

    public static void main(String[] args) {
        int[] values = {10, 20, 30};
        int index = 1;

        // Plain get and set access the selected array position.
        System.out.println("Before: " + ELEMENT.get(values, index));
        ELEMENT.set(values, index, 99);
        System.out.println("After set: " + values[index]);

        // compareAndSet updates only when the current value is still the expected value.
        boolean updated = ELEMENT.compareAndSet(values, index, 99, 100);
        System.out.println("Compare-and-set succeeded: " + updated);
        System.out.println("Final value: " + values[index]);
    }
}
