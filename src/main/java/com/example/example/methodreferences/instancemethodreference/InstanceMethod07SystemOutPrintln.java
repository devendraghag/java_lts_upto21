package com.example.methodreferences.instancemethodreference;

import java.util.function.Consumer;

/** Medium: System.out is a specific PrintStream object, so ::println is an object reference. */
public class InstanceMethod07SystemOutPrintln {
    public static void main(String[] args) {
        Consumer<String> lambda = text -> System.out.println(text);
        Consumer<String> reference = System.out::println;

        lambda.accept("Lambda output");
        reference.accept("System.out method reference");
    }
}
