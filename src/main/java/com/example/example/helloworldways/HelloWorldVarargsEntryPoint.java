package com.example.helloworldways;

/** Varargs syntax compiles to a String[] parameter and works as a launcher entry point. */
public class HelloWorldVarargsEntryPoint {
    public static void main(String... args) {
        String name = args.length > 0 ? args[0] : "World";
        System.out.println("Hello, " + name + "! (varargs entry point)");
    }
}
