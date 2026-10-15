package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class8: HTML template using Text Blocks
/**
 * Easy: Demonstrates Text Block09 Html Template in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock09HtmlTemplate {
    public static void main(String[] args) {

        String html = """
                <html>
                    <head>
                        <title>Text Blocks</title>
                    </head>
                    <body>
                        <h1>Hello Java</h1>
                        <p>Text Blocks are awesome!</p>
                    </body>
                </html>
                """;

        System.out.println(html);
    }
}
