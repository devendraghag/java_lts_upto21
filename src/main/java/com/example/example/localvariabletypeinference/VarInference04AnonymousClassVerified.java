package level03_advanced.jdk10.localvariabletypeinference;

/*
 * JDK 10 introduction-version bucket interview program: var with anonymous class.
 *
 * Interview point:
 * - var can preserve the anonymous class type locally.
 * - The feature is local-variable inference, not dynamic typing.
 */
/**
 * Easy: Demonstrates Var Inference04 Anonymous Class Verified in the Local Variable Type Inference topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarInference04AnonymousClassVerified {
    public static void main(String[] args) {
        var service = new Object() {
            String name() {
                return "anonymous-service";
            }
        };

        check("anonymous-service".equals(service.name()), "Anonymous var type mismatch");
        System.out.println(service.name());
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
