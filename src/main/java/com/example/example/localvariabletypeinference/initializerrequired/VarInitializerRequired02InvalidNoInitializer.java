package level03_advanced.jdk10.localvariabletypeinference.initializerrequired;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

/**
 * Easy: Demonstrates Var Initializer Required02 Invalid No Initializer in the Local Variable Type Inference / Initializer Required topic.
 * Inspect the commented example to see which usage the compiler rejects.
 * Medium: Identify the exact compiler rule before checking the commented invalid statement.
 * Tough: Explain the compile-time failure precisely, then state the smallest valid correction.
 */
public class VarInitializerRequired02InvalidNoInitializer {
    public static void main(String[] args) {
        // var b; ❌ Compilation error: cannot use var without initializer
    }
}