package level03_advanced.jdk21.sequencedcollections.sequencedcollections;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.LinkedHashSet;
import java.util.SequencedSet;

/** Level 4: SequencedSet combines uniqueness with an explicitly maintained order. */
public class SequencedCollection04SequencedSet {
    public static void main(String[] args) {
        SequencedSet<String> languages = new LinkedHashSet<>();
        languages.addLast("Java");
        languages.addLast("Python");
        languages.addFirst("Python"); // Existing element moves to the first position.

        System.out.println(languages);            // [Python, Java]
        System.out.println(languages.getFirst());  // Python
        System.out.println(languages.reversed());  // [Java, Python]
    }
}
