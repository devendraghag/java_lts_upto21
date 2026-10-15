package com.example.variables;

/** Level 05: Demonstrates local variable scope and the lifetime of an instance field. */
public class Variable05ScopeDemo {
    private int total; // Instance field remains available for the object's lifetime.

    private void add(int amount) {
        int updatedTotal = total + amount; // Local variable exists only during this call.
        total = updatedTotal;

        {
            String message = "Added " + amount; // Block-local variable.
            System.out.println(message);
        }
        // message is out of scope here.
    }

    public static void main(String[] args) {
        Variable05ScopeDemo account = new Variable05ScopeDemo();
        account.add(5);
        account.add(3);
        System.out.println("Stored total=" + account.total);
    }
}
