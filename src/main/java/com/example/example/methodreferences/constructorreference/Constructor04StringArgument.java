package com.example.methodreferences.constructorreference;

import java.util.function.Function;

/** Easy+: a one-argument constructor matches Function<T, R>. */
public class Constructor04StringArgument {
    public static void main(String[] args) {
        // Input is the initial text; output is a new StringBuilder.
        Function<String, StringBuilder> lambda = text -> new StringBuilder(text);
        Function<String, StringBuilder> reference = StringBuilder::new;

        System.out.println(lambda.apply("JDK 21"));
        System.out.println(reference.apply("Constructor reference"));
    }
}
