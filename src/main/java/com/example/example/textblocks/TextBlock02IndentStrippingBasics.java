package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class2: Demonstrates automatic indentation stripping
/**
 * Easy: Demonstrates Text Block02 Indent Stripping Basics in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock02IndentStrippingBasics {
    public static void main(String[] args) {

        String text = """
                    Line One
                         Line Two
                    Line Three
                """;

        // Java removes common leading spaces automatically
        System.out.println(text);
    }
}
