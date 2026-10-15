package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.function.BiPredicate;

/** Easy+: receiver plus one method argument gives BiPredicate<String, String>. */
public class ArbitraryObject04StringStartsWith {
    public static void main(String[] args) {
        // First parameter is the receiver; second parameter is the prefix argument.
        BiPredicate<String, String> lambda = (text, prefix) -> text.startsWith(prefix);
        BiPredicate<String, String> reference = String::startsWith;

        System.out.println(lambda.test("Java Streams", "Java"));
        System.out.println(reference.test("Java Streams", "Stream"));
    }
}
