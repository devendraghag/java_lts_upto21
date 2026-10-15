package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleBinaryOperator;

/*
 DoubleBinaryOperator2: Find max double value
*/
/**
 * Easy: Demonstrates Double Binary Operator2 Max in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleBinaryOperator2_Max {
    public static void main(String[] args) {
        DoubleBinaryOperator max = Math::max;
        System.out.println(max.applyAsDouble(5.5, 9.5));
    }
}
