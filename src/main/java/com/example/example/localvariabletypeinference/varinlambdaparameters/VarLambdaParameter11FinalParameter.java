package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).

import java.util.function.UnaryOperator;

/* JDK 11 permits final on a var lambda parameter. */
/**
 * Easy: Demonstrates Var Lambda Parameter11 Final Parameter in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class VarLambdaParameter11FinalParameter {
    public static void main(String[] args) {
        UnaryOperator<String> normalize =
                (final var value) -> value.strip().toUpperCase();
        String result = normalize.apply("  java  ");
        if (!"JAVA".equals(result)) {
            throw new IllegalStateException("Unexpected normalized value");
        }
        System.out.println(result);
    }
}
