package level03_advanced.jdk09.trywithresourcesenhancement;
// JDK history: Introduction baseline: JDK 9 (the release bucket for this topic).


/*
 * Interview level: Intermediate.
 * Feature combination/topic: effectively final resource.
 *
 * Notes:
 * - Kept in the JDK9 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Try With Resources Enh03 Effectively Final Rule in the Try With Resources Enhancement topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
public class TryWithResourcesEnh03EffectivelyFinalRule {
    public static void main(String[] args) throws Exception {
        java.io.ByteArrayInputStream input = new java.io.ByteArrayInputStream("A".getBytes());
        try (input) {
            System.out.println(input.read());
        }
    }
}