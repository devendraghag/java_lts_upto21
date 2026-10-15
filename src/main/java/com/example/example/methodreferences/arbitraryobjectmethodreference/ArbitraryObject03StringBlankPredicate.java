package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.Predicate;

/** Easy: String::isBlank has shape String -> boolean, matching Predicate<String>. */
public class ArbitraryObject03StringBlankPredicate {
    public static void main(String[] args) {
        Predicate<String> lambda = s -> s.isBlank();
        Predicate<String> reference = String::isBlank;

        System.out.println(lambda.test("   "));
        System.out.println(reference.test("Java"));
    }
}
