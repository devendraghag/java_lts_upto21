package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.util.List;

/**
 * Easy: Demonstrates Var Lambda Parameter06 Equivalent To Inferred Lambda in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class VarLambdaParameter06EquivalentToInferredLambda {

    public static void main(String[] args) {

        List<String> data = List.of("A", "BB", "CCC");

        // Lambda with inferred parameter (preferred when no annotation needed)
        data.stream()
            .map(s -> s.length())   // 's' inferred as String
            .forEach(System.out::println);

        // Lambda using 'var'
        // Functionally identical to above
        data.stream()
            .map((var s) -> s.length())
            .forEach(System.out::println);
    }
}
