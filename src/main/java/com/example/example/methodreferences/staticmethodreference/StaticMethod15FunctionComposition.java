package com.example.methodreferences.staticmethodreference;

import java.util.function.Function;

/** Hard: static method references can be composed as ordinary Function values. */
public class StaticMethod15FunctionComposition {
    static class TextTools {
        static String trim(String text) {
            return text.trim();
        }

        static String uppercase(String text) {
            return text.toUpperCase();
        }
    }

    public static void main(String[] args) {
        Function<String, String> trim = TextTools::trim;
        Function<String, String> uppercase = TextTools::uppercase;
        Function<String, String> cleanUppercase = trim.andThen(uppercase);

        System.out.println(cleanUppercase.apply("  java streams  "));
    }
}
