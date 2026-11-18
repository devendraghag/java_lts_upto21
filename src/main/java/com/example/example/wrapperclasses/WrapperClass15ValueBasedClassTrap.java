package com.example.example.wrapperclasses;

/** Wrapper objects are value-based; do not rely on identity or synchronize on them. */
public class WrapperClass15ValueBasedClassTrap {
    public static void main(String[] args) {
        Integer first = Integer.valueOf(1000);
        Integer second = Integer.valueOf(1000);

        System.out.println("Compare values with equals: " + first.equals(second));
        System.out.println("Identity comparison is not a value comparison: " + (first == second));
        System.out.println("Use a dedicated lock object instead of synchronizing on wrappers.");
    }
}
