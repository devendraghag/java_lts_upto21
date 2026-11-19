package com.example.example.helloworldways;

import java.util.function.Consumer;

/** Java 8: uses a method reference as the message consumer. */
public class HelloWorld12MethodReference {
    public static void main(String[] args) {
        Consumer<String> printer = System.out::println;
        printer.accept("Hello, World!");
    }
}
