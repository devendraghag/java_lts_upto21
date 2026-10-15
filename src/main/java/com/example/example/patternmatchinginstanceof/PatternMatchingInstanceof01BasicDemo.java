package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.


/*
 * JDK 16 introduction-version bucket feature: pattern matching for instanceof.
 *
 * The variable is declared inside the instanceof check and is automatically
 * available when the check succeeds.
 */
/**
 * Easy: Demonstrates Pattern Matching Instanceof01 Basic Demo in the Pattern Matching Instanceof topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class PatternMatchingInstanceof01BasicDemo {
    public static void main(String[] args) {
        Object value = "Java 17";

        if (value instanceof String text) {
            System.out.println("Length: " + text.length());
        }
    }
}

