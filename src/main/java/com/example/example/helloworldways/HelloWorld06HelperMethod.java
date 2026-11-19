package com.example.example.helloworldways;

/** Separates message creation from the main method. */
public class HelloWorld06HelperMethod {
    public static void main(String[] args) {
        System.out.println(createGreeting());
    }
    private static String createGreeting() { return "Hello, World!"; }
}
