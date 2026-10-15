package com.example.functionalinterfaces.functioninterfaces;

import java.util.function.Function;

/** Pattern 17: reuse a Function and compose transformations with andThen and compose. */
public class FunctionPattern17_CompositionAndReuse {
    public static void main(String[] args) {
        Function<String, String> trim = String::trim;
        Function<String, String> uppercase = String::toUpperCase;
        Function<String, String> trimThenUppercase = trim.andThen(uppercase);
        Function<String, Integer> lengthAfterTrim = trim.andThen(String::length);
        Function<String, Integer> lengthThenLabel = String::length;

        System.out.println(trimThenUppercase.apply("  java  "));
        System.out.println("Trimmed length: " + lengthAfterTrim.apply("  Spring  "));
        System.out.println("Composed length: " + lengthThenLabel.compose(trim).apply("  SQL  "));
    }
}