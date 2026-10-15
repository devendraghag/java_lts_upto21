package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.UnaryOperator;

/*
 UnaryOperator5: identity() method
 Returns input as-is
*/
/**
 * Easy: Demonstrates Unary Operator5 Identity in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class UnaryOperator5_Identity {
    public static void main(String[] args) {
        UnaryOperator<String> identity = UnaryOperator.identity();
        System.out.println(identity.apply("No Change"));
    }
}
