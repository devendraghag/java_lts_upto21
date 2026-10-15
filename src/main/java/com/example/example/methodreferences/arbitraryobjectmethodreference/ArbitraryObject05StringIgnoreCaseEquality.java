package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.BiPredicate;

/** Easy+: the first String becomes the receiver of equalsIgnoreCase(). */
public class ArbitraryObject05StringIgnoreCaseEquality {
    public static void main(String[] args) {
        BiPredicate<String, String> lambda = (left, right) -> left.equalsIgnoreCase(right);
        BiPredicate<String, String> reference = String::equalsIgnoreCase;

        System.out.println(lambda.test("JAVA", "java"));
        System.out.println(reference.test("Stream", "STREAM"));
    }
}
