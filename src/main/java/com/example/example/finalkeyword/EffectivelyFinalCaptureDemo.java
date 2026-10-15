package com.example.finalkeyword;

import java.util.function.IntUnaryOperator;

/** Explicit final and effectively final local variables captured by lambdas. */
public class EffectivelyFinalCaptureDemo {
    public static void main(String[] args) {
        final int offset = 10;
        int multiplier = 3; // Effectively final: initialized once and never reassigned.

        IntUnaryOperator transform = value -> value * multiplier + offset;
        System.out.println(transform.applyAsInt(5));

        // multiplier = 4; // Uncommenting this makes it non-effectively-final and breaks the lambda.
    }
}
