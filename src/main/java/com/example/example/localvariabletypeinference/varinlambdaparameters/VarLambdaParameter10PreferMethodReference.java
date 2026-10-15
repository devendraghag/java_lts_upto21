package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.util.List;

/**
 * Easy: Demonstrates Var Lambda Parameter10 Prefer Method Reference in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class VarLambdaParameter10PreferMethodReference {

    public static void main(String[] args) {

        List<String> names = List.of("java", "jdk");

        // Method reference is cleaner than lambda + var
        // Prefer this when no transformation is needed
        names.forEach(System.out::println);
    }
}
