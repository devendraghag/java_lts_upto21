package level03_advanced.jdk21.sequencedcollections.sequencedcollections;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.ArrayList;
import java.util.SequencedCollection;

/** Level 1: access and modify the first and last elements of a sequence. */
public class SequencedCollection01ArrayListEndpoints {
    public static void main(String[] args) {
        SequencedCollection<String> items = new ArrayList<>();

        items.addLast("middle");
        items.addFirst("first");
        items.addLast("last");

        System.out.println(items);            // [first, middle, last]
        System.out.println(items.getFirst());  // first
        System.out.println(items.getLast());   // last

        items.removeFirst();
        items.removeLast();
        System.out.println(items);            // [middle]
    }
}
