package com.example.optionalclass;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/** Demonstrates eager and lazy Optional fallback methods. */
public class OptionalFallbackMethodsDemo {
    private static String computeFallback(AtomicInteger calls) {
        calls.incrementAndGet();
        return "computed fallback";
    }

    public static void main(String[] args) {
        AtomicInteger calls = new AtomicInteger();
        Optional<String> present = Optional.of("available");

        String eager = present.orElse(computeFallback(calls));
        System.out.println("orElse: " + eager + "; fallback calls=" + calls.get());

        calls.set(0);
        String lazy = present.orElseGet(() -> computeFallback(calls));
        System.out.println("orElseGet: " + lazy + "; fallback calls=" + calls.get());

        String required = present.orElseThrow(); // No-argument overload since Java 10.
        System.out.println("orElseThrow: " + required);
    }
}
