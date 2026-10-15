package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.UnaryOperator;

/*
 UnaryOperator2: Convert string to uppercase
*/
/**
 * Easy: Demonstrates Unary Operator2 String Uppercase in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class UnaryOperator2_StringUppercase {
    public static void main(String[] args) {
        UnaryOperator<String> toUpper = String::toUpperCase;
        System.out.println(toUpper.apply("java"));
    }
}
