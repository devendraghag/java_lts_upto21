package level03_advanced.jdk21.sequencedcollections.sequencedcollections;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.SequencedSet;
import java.util.TreeSet;

/** Level 5: sorted sets are sequenced, but their comparator controls their order. */
public class SequencedCollection05SortedSet {
    public static void main(String[] args) {
        SequencedSet<Integer> numbers = new TreeSet<>();
        numbers.add(20);
        numbers.add(10);
        numbers.add(30);

        System.out.println(numbers);            // [10, 20, 30]
        System.out.println(numbers.getFirst());  // 10
        System.out.println(numbers.getLast());   // 30
        System.out.println(numbers.reversed());  // [30, 20, 10]

        // addFirst(5) and addLast(40) are unsupported: TreeSet order is comparator-defined.
    }
}
