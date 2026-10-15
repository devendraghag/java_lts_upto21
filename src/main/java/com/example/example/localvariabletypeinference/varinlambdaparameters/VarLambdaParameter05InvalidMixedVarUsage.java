package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


/**
 * Easy: Demonstrates Var Lambda Parameter05 Invalid Mixed Var Usage in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Inspect the commented example to see which usage the compiler rejects.
 * Medium: Identify the exact compiler rule before checking the commented invalid statement.
 * Tough: Explain the compile-time failure precisely, then state the smallest valid correction.
 */
public class VarLambdaParameter05InvalidMixedVarUsage {

    public static void main(String[] args) {

        // ❌ INVALID CODE (compiler error)
        // Rule: If one parameter uses 'var', ALL must use 'var'

        // BiFunction<Integer, Integer, Integer> add =
        //        (var a, b) -> a + b;
    }
}
