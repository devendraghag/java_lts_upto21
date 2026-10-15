package com.example.helloworldways;

/** Demonstrates the standard Java launcher entry point and command-line arguments. */
public class HelloWorldEntryPointDemo {
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "World";
        System.out.println("Hello, " + name + "!");
        main(); // An overloaded helper is an ordinary method, not the launcher entry point.
    }

    private static void main() {
        System.out.println("Hello from an overloaded helper method.");
    }
}
