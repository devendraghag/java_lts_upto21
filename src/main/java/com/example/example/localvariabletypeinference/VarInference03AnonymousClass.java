package level03_advanced.jdk10.localvariabletypeinference;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).


/*
 * Interview level: Advanced.
 * Feature combination/topic: var with anonymous class.
 *
 * Notes:
 * - Kept in the JDK10 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Var Inference03 Anonymous Class in the Local Variable Type Inference topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarInference03AnonymousClass {
    public static void main(String[] args) throws Exception {
        var service = new Object() { String name() { return "service"; } };
        System.out.println(service.name());
    }
}