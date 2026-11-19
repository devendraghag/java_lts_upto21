package com.example.example.helloworldways;

import java.util.function.Consumer;

/** Java 8: sends the greeting to a Consumer using a lambda. */
public class HelloWorld11LambdaConsumer {
    public static void main(String[] args) {
        Consumer<String> printer = message -> System.out.println(message);
        printer.accept("Hello, World!");
    }
}
