package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.ToIntFunction;

/** Easy: String::length has shape String -> int, matching ToIntFunction<String>. */
public class ArbitraryObject02StringLength {
    public static void main(String[] args) {
        // Lambda: the input String is the receiver of length().
        ToIntFunction<String> lambda = s -> s.length();
        ToIntFunction<String> reference = String::length;

        System.out.println(lambda.applyAsInt("Streams"));
        System.out.println(reference.applyAsInt("Java 21"));
    }
}
