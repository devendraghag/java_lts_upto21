package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.


/*
 * Interview level: Advanced.
 * Feature combination/topic: instanceof with record type.
 *
 * Notes:
 * - Kept in the JDK16 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Pattern Matching Instanceof06 With Record in the Pattern Matching Instanceof topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
public class PatternMatchingInstanceof06WithRecord {
    public static void main(String[] args) throws Exception {
        Object value = new Point(1, 2);
        if (value instanceof Point point) { System.out.println(point.x() + point.y()); }
    }

    record Point(int x, int y) {}
    }