package com.example.example.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/** Demonstrates a VarHandle for a static field, using {@code var} for local variables. */
public class VarHandle06VarStaticFieldAccess {
    private static int total;
    private static final VarHandle TOTAL;

    static {
        try {
            TOTAL = MethodHandles.lookup()
                    .findStaticVarHandle(VarHandle06VarStaticFieldAccess.class, "total", int.class);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static void main(String[] args) {
        TOTAL.set(100); // Static field access needs no object argument.

        var oldTotal = (int) TOTAL.getAndAdd(25);
        var newTotal = (int) TOTAL.get();

        System.out.println("Previous total: " + oldTotal);
        System.out.println("Current total: " + newTotal);
    }
}
