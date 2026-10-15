package com.example.methodreferences.staticmethodreference;

import java.util.function.BiPredicate;

/** Medium: static comparison method takes both BiPredicate inputs and returns boolean. */
public class StaticMethod07BiPredicate {
    static class TextRules {
        static boolean sameLength(String first, String second) {
            return first.length() == second.length();
        }
    }

    public static void main(String[] args) {
        BiPredicate<String, String> lambda = (first, second) -> TextRules.sameLength(first, second);
        BiPredicate<String, String> reference = TextRules::sameLength;

        System.out.println(lambda.test("cat", "dog"));
        System.out.println(reference.test("Java", "Code"));
    }
}
