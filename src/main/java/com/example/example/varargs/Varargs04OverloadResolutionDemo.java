package com.example.varargs;

/** Level 4: see how Java chooses fixed-arity overloads before varargs overloads. */
public class Varargs04OverloadResolutionDemo {
    public static void main(String[] args) {
        display("one value"); // Fixed-arity overload is preferred.
        display(); // No fixed-arity match, so Java uses the varargs method.
        display(new Object[]{"red", "green"}); // Pass an array to the varargs overload.
    }

    private static void display(Object value) {
        System.out.println("Fixed-arity overload: " + value);
    }

    private static void display(Object... values) {
        System.out.println("Varargs overload: " + values.length + " value(s)");
    }
}
