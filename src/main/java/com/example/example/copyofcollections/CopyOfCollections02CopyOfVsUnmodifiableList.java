package level03_advanced.jdk10.copyofcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * JDK 10 introduction-version bucket interview program: List.copyOf() vs Collections.unmodifiableList().
 *
 * Interview point:
 * - unmodifiableList is a read-only view over the original list.
 * - List.copyOf creates an unmodifiable snapshot.
 */
/**
 * Easy: Demonstrates Copy Of Collections02 Copy Of Vs Unmodifiable List in the Copy Of Collections topic.
 * Run it to observe the basic behavior and output.
 * Medium: Track element order, duplicates, lookup behavior, and the collection state after each operation.
 * Tough: Analyze complexity, mutation during iteration, view behavior, and unsupported operations.
 */
public class CopyOfCollections02CopyOfVsUnmodifiableList {
    public static void main(String[] args) {
        //List.of("A", "B") create immutable list but List<String> mutable = new ArrayList<>(List.of("A", "B")) create mutable list
        List<String> mutable = new ArrayList<>(List.of("A", "B")); // List.of creates an immutable list, but we wrap it in a mutable ArrayList
        List<String> mutable1 = new ArrayList<>(Arrays.asList("A", "B")); // List.of creates an immutable list, but we wrap it in a mutable ArrayList
        List<String> view = Collections.unmodifiableList(mutable);
        List<String> snapshot = List.copyOf(mutable);
        System.out.println(mutable.get(0));
        System.out.println(mutable.get(1));
        System.out.println(mutable1.get(0));
        System.out.println(mutable1.get(1));
        mutable.add("C");
        mutable1.add("C");

        check(view.size() == 3, "Unmodifiable view should reflect backing list");
        check(snapshot.size() == 2, "copyOf snapshot should not change");
        System.out.println("view=" + view + ", snapshot=" + snapshot);
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new IllegalStateException(message);
    }
}
