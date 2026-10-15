package com.example.methodreferences.instancemethodreference;

import java.util.Optional;
import java.util.function.Function;

/** Harder: Optional.map accepts Function; this reference uses a chosen formatter object. */
public class InstanceMethod13OptionalMap {
    static class Formatter {
        String normalize(String input) {
            return input.trim().toLowerCase();
        }
    }

    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        Function<String, String> lambda = input -> formatter.normalize(input);
        Function<String, String> reference = formatter::normalize;
        Optional<String> raw = Optional.of("  Java 21  ");

        System.out.println(raw.map(lambda));
        System.out.println(raw.map(reference));
    }
}
