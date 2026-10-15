package com.example.terminaloperations;

import java.util.List;
import java.util.function.Consumer;

/** Easy: forEach is a terminal operation that performs an action for each element. */
public class TerminalOperationPractice01ForEach {
    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Kotlin", "Scala");
        Consumer<String> lambda = language -> System.out.println("Language: " + language);
        Consumer<String> methodReference = System.out::println;

        languages.stream().forEach(lambda);
        System.out.println("Direct method reference:");
        languages.stream().forEach(methodReference);
    }
}
