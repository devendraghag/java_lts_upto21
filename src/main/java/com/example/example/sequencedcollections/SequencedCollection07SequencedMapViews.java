package level03_advanced.jdk21.sequencedcollections.sequencedcollections;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;

/** Level 7: SequencedMap exposes its keys, values, and entries in encounter order. */
public class SequencedCollection07SequencedMapViews {
    public static void main(String[] args) {
        SequencedMap<String, Integer> scores = new LinkedHashMap<>();
        scores.putLast("Asha", 90);
        scores.putLast("Ben", 85);
        scores.putLast("Mina", 95);

        SequencedSet<String> keys = scores.sequencedKeySet();
        SequencedCollection<Integer> values = scores.sequencedValues();
        SequencedSet<Map.Entry<String, Integer>> entries = scores.sequencedEntrySet();

        System.out.println(keys);               // [Asha, Ben, Mina]
        System.out.println(values);             // [90, 85, 95]
        System.out.println(entries);            // [Asha=90, Ben=85, Mina=95]
        System.out.println(keys.reversed());    // [Mina, Ben, Asha]

        keys.remove("Ben"); // The key view is backed by the map, so this removes the entry.
        System.out.println(scores);              // {Asha=90, Mina=95}
    }
}
