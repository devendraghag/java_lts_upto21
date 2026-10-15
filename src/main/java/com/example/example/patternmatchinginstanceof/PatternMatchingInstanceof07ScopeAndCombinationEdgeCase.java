package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.


/*
 * Interview level: Intermediate.
 * Feature combination/topic: pattern scope with and.
 *
 * Notes:
 * - Kept in the JDK16 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Pattern Matching Instanceof07 Scope And Combination Edge Case in the Pattern Matching Instanceof topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class PatternMatchingInstanceof07ScopeAndCombinationEdgeCase {
    public static void main(String[] args) throws Exception {
        Object value = "pattern";
        if (value instanceof String text && text.startsWith("p")) {
            System.out.println(text);
        }
    }
}