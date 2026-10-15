package com.example.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/** Demonstrates Iterable.forEach and common Consumer styles. */
public class IterableForEachDemo {
    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Kotlin", "Scala");

        System.out.println("Lambda:");
        languages.forEach(language -> System.out.println(language));

        System.out.println("Method reference:");
        languages.forEach(System.out::println);

        System.out.println("Consumer variable:");
        Consumer<String> printUppercase = language ->
                System.out.println(language.toUpperCase());
        languages.forEach(printUppercase);

        System.out.println("Anonymous Consumer:");
        languages.forEach(new Consumer<>() {
            @Override
            public void accept(String language) {
                System.out.println("Language: " + language);
            }
        });

        System.out.println("Array through Arrays.stream:");
        String[] tools = {"javac", "java"};
        Arrays.stream(tools).forEach(System.out::println);
    }
}
