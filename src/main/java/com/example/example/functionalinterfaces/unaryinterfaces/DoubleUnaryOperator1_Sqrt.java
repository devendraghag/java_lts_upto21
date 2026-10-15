package com.example.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleUnaryOperator;

/*
 DoubleUnaryOperator1: Calculate square root
*/
/**
 * Easy: Demonstrates Double Unary Operator1 Sqrt in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleUnaryOperator1_Sqrt {
    public static void main(String[] args) {
        DoubleUnaryOperator sqrt = Math::sqrt;
        System.out.println(sqrt.applyAsDouble(25));
    }
}


// UnaryOperator<T> takes one  inputs of the same type and returns the same type.