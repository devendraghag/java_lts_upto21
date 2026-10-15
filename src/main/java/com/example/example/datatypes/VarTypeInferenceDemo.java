package com.example.datatypes;

import java.util.List;

/** Demonstrates local variable type inference with var, available since Java 10. */
public class VarTypeInferenceDemo {
    public static void main(String[] args) {
        var message = "var is not a new data type"; // Inferred as String.
        var count = 3;                              // Inferred as int.
        var languages = List.of("Java", "Kotlin"); // Inferred as List<String>.

        System.out.println(message);
        System.out.println("count type is inferred from initializer: " + count);
        languages.forEach(System.out::println);

        // var is only for local variables with an initializer.
        // It cannot declare a field, method parameter, or variable initialized only to null.
    }
}
