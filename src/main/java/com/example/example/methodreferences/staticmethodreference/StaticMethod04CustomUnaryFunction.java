package com.example.methodreferences.staticmethodreference;

import java.util.function.UnaryOperator;

/** Easy+: a static utility method can match a UnaryOperator<String>. */
public class StaticMethod04CustomUnaryFunction {
    static class TextTools {
        static String reverse(String text) {
            return new StringBuilder(text).reverse().toString();
        }
    }

    public static void main(String[] args) {
        UnaryOperator<String> lambda = text -> TextTools.reverse(text);
        UnaryOperator<String> reference = TextTools::reverse;

        System.out.println(lambda.apply("Java"));
        System.out.println(reference.apply("Streams"));
    }
}
