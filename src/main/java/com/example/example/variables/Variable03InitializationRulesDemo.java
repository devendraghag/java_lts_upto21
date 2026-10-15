package com.example.variables;

/** Level 03: fields receive defaults, but local variables must be initialized before use. */
public class Variable03InitializationRulesDemo {
    // Fields are given default values automatically when an object is created.
    private int instanceCount;
    private String instanceName;
    private static boolean applicationReady;

    public static void main(String[] args) {
        Variable03InitializationRulesDemo example = new Variable03InitializationRulesDemo();
        System.out.println("Default int field: " + example.instanceCount); // 0
        System.out.println("Default reference field: " + example.instanceName); // null
        System.out.println("Default static boolean: " + applicationReady); // false

        int localCount = 0; // Local variables do not get automatic default values.
        // int uninitialized;
        // System.out.println(uninitialized); // Compile-time error: initialize before reading.
        System.out.println("Initialized local: " + localCount);
    }
}
