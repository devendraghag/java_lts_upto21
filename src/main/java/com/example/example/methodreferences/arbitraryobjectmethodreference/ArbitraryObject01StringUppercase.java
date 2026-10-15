package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.Function;

/** Easy: String is the receiver type; each input String supplies the object.
ArbitraryObject means its accept object and call method which applicable or want to apply on that object
 */

public class ArbitraryObject01StringUppercase {
    public static void main(String[] args) {
        // Lambda: take a String s, then call s.toUpperCase().
        Function<String, String> lambda = s -> s.toUpperCase();

        // Equivalent method reference: receiver String is the first Function input.
        Function<String, String> reference = String::toUpperCase;

        System.out.println(lambda.apply("hello"));
        System.out.println(reference.apply("java"));
    }
}
