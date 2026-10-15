package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongBinaryOperator;

/*
 LongBinaryOperator1: Multiply two long values
*/
/**
 * Easy: Demonstrates Long Binary Operator1 Multiply in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongBinaryOperator1_Multiply {
    public static void main(String[] args) {
        LongBinaryOperator multiply = (a, b) -> a * b;
        System.out.println(multiply.applyAsLong(10L, 20L));
    }
}
