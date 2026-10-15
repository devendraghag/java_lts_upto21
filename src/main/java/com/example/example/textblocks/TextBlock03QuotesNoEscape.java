package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class3: Text Block containing double quotes
/**
 * Easy: Demonstrates Text Block03 Quotes No Escape in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock03QuotesNoEscape {
    public static void main(String[] args) {

        String json = """
                {
                  "name": "Devendra",
                  "role": "Java Developer",
                  "active": true
                }
                """;

        // No need to escape double quotes
        System.out.println(json);
    }
}
