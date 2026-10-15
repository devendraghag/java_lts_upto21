package com.example.methodreferences.staticmethodreference;

import java.util.function.Function;
import java.util.function.ToIntFunction;

/** Harder: the target interface determines which overloaded static method applies. */
public class StaticMethod14TargetTypeSelectsOverload {
    static class TextTools {
        static String describe(String text) {
            return "text=" + text;
        }

        static int describe(int number) {
            return number * 2;
        }
    }

    public static void main(String[] args) {
        Function<String, String> fromText = TextTools::describe;
        ToIntFunction<Integer> fromNumber = TextTools::describe;

        System.out.println(fromText.apply("Java"));
        System.out.println(fromNumber.applyAsInt(21));
    }
}
