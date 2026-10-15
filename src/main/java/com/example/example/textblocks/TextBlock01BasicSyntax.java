package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class1: Basic usage of Text Blocks
/**
 * Easy: Demonstrates Text Block01 Basic Syntax in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock01BasicSyntax {
    public static void main(String[] args) {

        // Simple multiline text block
        String message = """
                Hello Java
                This is a Text Block
                It supports multiple lines
                """;

        System.out.println(message);
    }
}
