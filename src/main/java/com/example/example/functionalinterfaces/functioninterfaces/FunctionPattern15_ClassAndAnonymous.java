package com.example.functionalinterfaces.functioninterfaces;

import java.util.function.Function;

/** Pattern 15: implement Function with a named class or anonymous class. */
public class FunctionPattern15_ClassAndAnonymous {
    private static final class TextLength implements Function<String, Integer> {
        @Override
        public Integer apply(String text) {
            return text.length();
        }
    }

    public static void main(String[] args) {
        Function<String, Integer> named = new TextLength();
        Function<String, Integer> anonymous = new Function<>() {
            @Override
            public Integer apply(String text) {
                return text.length() * 2;
            }
        };
        System.out.println(named.apply("Java"));
        System.out.println(anonymous.apply("Java"));
    }
}