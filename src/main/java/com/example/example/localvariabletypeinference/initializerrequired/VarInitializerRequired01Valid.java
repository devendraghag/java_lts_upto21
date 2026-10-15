package level03_advanced.jdk10.localvariabletypeinference.initializerrequired;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

/**
 * Easy: Demonstrates Var Initializer Required01 Valid in the Local Variable Type Inference / Initializer Required topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarInitializerRequired01Valid {
    public static void main(String[] args) {
        // Initializer is mandatory
        var a = 100;
        System.out.println(a);
    }
}