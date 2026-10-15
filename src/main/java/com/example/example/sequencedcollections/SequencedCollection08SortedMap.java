package level03_advanced.jdk21.sequencedcollections.sequencedcollections;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.SequencedMap;
import java.util.TreeMap;

/** Level 8: sorted maps implement SequencedMap, with order determined by their keys. */
public class SequencedCollection08SortedMap {
    public static void main(String[] args) {
        SequencedMap<String, Integer> scores = new TreeMap<>();
        scores.put("Zara", 90);
        scores.put("Asha", 95);
        scores.put("Mina", 85);

        System.out.println(scores);               // {Asha=95, Mina=85, Zara=90}
        System.out.println(scores.firstEntry());  // Asha=95
        System.out.println(scores.lastEntry());   // Zara=90
        System.out.println(scores.reversed());    // {Zara=90, Mina=85, Asha=95}

        // putFirst and putLast are unsupported: TreeMap order is determined by its keys.
    }
}
