package com.example.example.wrapperclasses;

/** Prefer valueOf or autoboxing; wrapper constructors are deprecated. */
public class WrapperClass14DeprecatedConstructors {
    public static void main(String[] args) {
        Integer fromFactory = Integer.valueOf("25");
        Integer fromAutoboxing = 25;

        System.out.println("valueOf: " + fromFactory);
        System.out.println("autoboxing: " + fromAutoboxing);
        // Avoid new Integer(25): wrapper constructors are deprecated for removal.
    }
}
