package com.example.methodreferences.instancemethodreference;

import java.util.function.Function;

/** Easy: Function maps an input to a result by calling a method on one captured object. */
public class InstanceMethod03Function {
    static class TextFormatter {
        String surround(String text) {
            return "[" + text + "]";
        }
    }

    public static void main(String[] args) {
        TextFormatter formatter = new TextFormatter();
        Function<String, String> lambda = text -> formatter.surround(text);
        Function<String, String> reference = formatter::surround;

        System.out.println(lambda.apply("Java"));
        System.out.println(reference.apply("JDK 21"));
    }
}
