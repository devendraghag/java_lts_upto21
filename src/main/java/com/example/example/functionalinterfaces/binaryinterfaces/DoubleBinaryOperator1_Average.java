package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleBinaryOperator;

/*
 DoubleBinaryOperator1: Calculate average of two values
*/
/**
 * Easy: Demonstrates Double Binary Operator1 Average in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleBinaryOperator1_Average {
    public static void main(String[] args) {
        DoubleBinaryOperator avg = (a, b) -> (a + b) / 2;
        System.out.println(avg.applyAsDouble(10.0, 20.0));
    }
}
