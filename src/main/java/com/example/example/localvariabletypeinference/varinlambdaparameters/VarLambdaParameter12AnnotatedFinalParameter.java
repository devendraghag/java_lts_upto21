package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.function.BiFunction;

/* Demonstrates uniform modifiers: every var parameter is final and annotated. */
/**
 * Easy: Demonstrates Var Lambda Parameter12 Annotated Final Parameter in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class VarLambdaParameter12AnnotatedFinalParameter {
    @Target(ElementType.PARAMETER)
    private @interface Validated {
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> maximum =
                (@Validated final var left, @Validated final var right) ->
                        Math.max(left, right);

        int result = maximum.apply(11, 8);
        if (result != 11) {
            throw new IllegalStateException("Unexpected maximum");
        }

        System.out.println(result);
    }
}
