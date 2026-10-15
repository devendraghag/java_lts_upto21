package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.


/*
 * JDK 16 introduction-version bucket interview program: pattern matching for instanceof.
 *
 * Interview point:
 * - Pattern variables are available only where the compiler knows the match succeeded.
 * - This removes manual casting after instanceof.
 */
/**
 * Easy: Demonstrates Pattern Matching Instanceof05 Combining With And in the Pattern Matching Instanceof topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class PatternMatchingInstanceof05CombiningWithAnd {
    public static void main(String[] args) {
        Object value = "Java 17";

        if (value instanceof String text && text.length() > 5) {
            System.out.println(text.toUpperCase());
        }
    }
}

