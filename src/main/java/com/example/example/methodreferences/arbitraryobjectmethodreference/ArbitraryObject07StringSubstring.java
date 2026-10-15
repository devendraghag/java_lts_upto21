package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.BiFunction;

/** Medium: receiver String plus the int index (boxed as Integer) match BiFunction. */
public class ArbitraryObject07StringSubstring {
    public static void main(String[] args) {
        // String.substring(int) has one explicit argument after the receiver.
        BiFunction<String, Integer, String> lambda = (text, begin) -> text.substring(begin);
        BiFunction<String, Integer, String> reference = String::substring;

        System.out.println(lambda.apply("Programming", 3));
        System.out.println(reference.apply("MethodReference", 6));
    }
}
