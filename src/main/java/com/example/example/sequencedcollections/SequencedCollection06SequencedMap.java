package level03_advanced.jdk21.sequencedcollections.sequencedcollections;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.LinkedHashMap;
import java.util.SequencedMap;

/** Level 6: SequencedMap adds endpoint operations for ordered key-value entries. */
public class SequencedCollection06SequencedMap {
    public static void main(String[] args) {
        SequencedMap<String, Integer> scores = new LinkedHashMap<>();
        scores.putLast("Asha", 90);
        scores.putLast("Ben", 85);
        scores.putFirst("Mina", 95);

        System.out.println(scores);                // {Mina=95, Asha=90, Ben=85}
        System.out.println(scores.firstEntry());   // Mina=95
        System.out.println(scores.lastEntry());    // Ben=85
        System.out.println(scores.reversed());     // {Ben=85, Asha=90, Mina=95}

        System.out.println(scores.pollFirstEntry()); // Mina=95; also removes it
        System.out.println(scores);                  // {Asha=90, Ben=85}
    }
}
