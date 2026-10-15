package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongUnaryOperator;

/*
 LongUnaryOperator1: Square a long value
*/
/**
 * Easy: Demonstrates Long Unary Operator1 Square in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongUnaryOperator1_Square {
    public static void main(String[] args) {
        LongUnaryOperator square = x -> x * x;
        System.out.println(square.applyAsLong(10));
    }
}
