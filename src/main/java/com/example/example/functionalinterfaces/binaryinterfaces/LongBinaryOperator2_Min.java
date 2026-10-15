package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongBinaryOperator;

/*
 LongBinaryOperator2: Find minimum long value
*/
/**
 * Easy: Demonstrates Long Binary Operator2 Min in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongBinaryOperator2_Min {
    public static void main(String[] args) {
        LongBinaryOperator min = Math::min;
        System.out.println(min.applyAsLong(100L, 50L));
    }
}
