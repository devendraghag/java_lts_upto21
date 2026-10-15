package com.example.forloop;

import java.util.List;

/** Demonstrates local variable type inference in for-loop declarations (Java 10+). */
public class VarForLoopDemo {
    public static void main(String[] args) {
        for (var index = 0; index < 3; index++) {
            System.out.println("Inferred int index: " + index);
        }

        List<String> languages = List.of("Java", "Kotlin", "Scala");
        for (var language : languages) {
            System.out.println("Inferred element type String: " + language);
        }
    }
}
