package com.example.methodreferences.staticmethodreference;

import java.util.function.Function;

/** Easy: Integer.parseInt takes String and returns int, which is boxed as Integer. */
public class StaticMethod02ParseInteger {
    public static void main(String[] args) {
        Function<String, Integer> lambda = text -> Integer.parseInt(text);
        Function<String, Integer> reference = Integer::parseInt;

        System.out.println(lambda.apply("21"));
        System.out.println(reference.apply("2026"));
    }
}
