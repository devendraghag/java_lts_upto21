package com.example.functionalinterfaces.unaryinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/** Pattern 19: UnaryOperator transforms a value to another value of the same type. */
public class UnaryOperatorPattern19_CollectionTransformations {
    public static void main(String[] args) {
        UnaryOperator<String> trim = String::trim;
        UnaryOperator<String> uppercase = String::toUpperCase;
        Function<String, String> composed = trim.andThen(uppercase);
        UnaryOperator<String> normalize = value -> composed.apply(value);

        List<String> courses = new ArrayList<>(List.of(" java ", " spring ", " sql "));
        courses.replaceAll(normalize);
        System.out.println(courses);
        System.out.println("Identity: " + UnaryOperator.<String>identity().apply("Java"));
    }
}