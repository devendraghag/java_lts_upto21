package com.example.variables;

import java.util.List;

/** Level 12: Demonstrates local variable type inference with var (Java 10+). */
public class Variable12LocalTypeInferenceDemo {
    public static void main(String[] args) {
        var language = "Java"; // Inferred as String.
        var versions = List.of(17, 21); // Inferred as List<Integer>.
        var message = language + " versions: " + versions;

        System.out.println(message);
    }
}
