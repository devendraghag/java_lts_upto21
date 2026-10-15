package level03_advanced.jdk21.sequencedcollections.sequencedcollections;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.ArrayList;
import java.util.SequencedCollection;

/** Level 2: reversed() returns a live view with the opposite encounter order. */
public class SequencedCollection02ReversedView {
    public static void main(String[] args) {
        SequencedCollection<String> items = new ArrayList<>();
        items.addLast("A");
        items.addLast("B");
        items.addLast("C");

        SequencedCollection<String> reversed = items.reversed();
        System.out.println(items);     // [A, B, C]
        System.out.println(reversed);  // [C, B, A]

        reversed.addFirst("D");
        System.out.println(items);     // [A, B, C, D]
        System.out.println(reversed);  // [D, C, B, A]
    }
}
