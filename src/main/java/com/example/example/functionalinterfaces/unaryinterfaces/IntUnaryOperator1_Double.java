package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntUnaryOperator;

/*
 IntUnaryOperator1: Double an integer value
*/
/**
 * Easy: Demonstrates Int Unary Operator1 Double in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntUnaryOperator1_Double {
    public static void main(String[] args) {
        IntUnaryOperator doubler = x -> x * 2;
        System.out.println(doubler.applyAsInt(5));
    }
}
