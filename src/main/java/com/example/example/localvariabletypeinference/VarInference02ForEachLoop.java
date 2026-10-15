package level03_advanced.jdk10.localvariabletypeinference;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).


/*
 * Interview level: Beginner.
 * Feature combination/topic: var in loops.
 *
 * Notes:
 * - Kept in the JDK10 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Var Inference02 For Each Loop in the Local Variable Type Inference topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarInference02ForEachLoop {
    public static void main(String[] args) throws Exception {
        for (var value : java.util.List.of("A", "B")) {
            System.out.println(value);
        }
    }
}