package com.example.functionalinterfaces.functioninterfaces;

import java.util.function.Function;

/** Pattern 16: use static, instance, and constructor method references as Functions. */
public class FunctionPattern16_MethodReferences {
    private static String addPrefix(String text) {
        return "Course: " + text;
    }

    public static void main(String[] args) {
        Function<String, String> staticReference = FunctionPattern16_MethodReferences::addPrefix;
        Function<String, Integer> instanceReference = String::length;
        Function<String, StringBuilder> constructorReference = StringBuilder::new;

        System.out.println(staticReference.apply("Java"));
        System.out.println("Length: " + instanceReference.apply("Spring"));
        System.out.println("Builder: " + constructorReference.apply("SQL"));
    }
}