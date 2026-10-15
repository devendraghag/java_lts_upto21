package level03_advanced.jdk10.localvariabletypeinference.notforfieldsorparameters;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

/**
 * Easy: Demonstrates Var Not For Fields Or Parameters02 Parameter in the Local Variable Type Inference / Not For Fields Or Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarNotForFieldsOrParameters02Parameter {
    // static void test(var a) {} ❌ not allowed for parameters
    public static void main(String[] args) {
        System.out.println("var not allowed for parameters");
    }
}