package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class9: Demonstrates trailing newline behavior
/**
 * Easy: Demonstrates Text Block06 Trailing Newline Length in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock06TrailingNewlineLength {
    public static void main(String[] args) {

        String text = """
                Hello World
                """;

        // Length includes newline at end
        System.out.println("Length: " + text.length());
        System.out.print(text);
        System.out.print("END");
    }
}
