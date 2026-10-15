package level03_advanced.jdk10.copyofcollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * JDK 10 introduction-version bucket interview program: List.copyOf, Set.copyOf, Map.copyOf.
 *
 * Interview point:
 * - copyOf creates unmodifiable snapshots.
 * - Later changes to the original mutable collection are not reflected.
 */
/**
 * Easy: Demonstrates Copy Of Collections01 List Set Map Copy Of in the Copy Of Collections topic.
 * Run it to observe the basic behavior and output.
 * Medium: Track element order, duplicates, lookup behavior, and the collection state after each operation.
 * Tough: Analyze complexity, mutation during iteration, view behavior, and unsupported operations.
 */
public class CopyOfCollections01ListSetMapCopyOf {
    public static void main(String[] args) {
        List<String> mutableList = new ArrayList<>(List.of("A", "B"));
        Set<String> mutableSet = new HashSet<>(Set.of("X", "Y"));
        Map<String, Integer> mutableMap = new HashMap<>(Map.of("java", 11));

        List<String> listCopy = List.copyOf(mutableList);
        Set<String> setCopy = Set.copyOf(mutableSet);
        Map<String, Integer> mapCopy = Map.copyOf(mutableMap);
        mutableList.add("C");

        check(listCopy.size() == 2, "List.copyOf should be snapshot");
        check(setCopy.contains("X"), "Set.copyOf mismatch");
        check(mapCopy.get("java") == 11, "Map.copyOf mismatch");
        System.out.println(listCopy + " " + setCopy + " " + mapCopy);
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new IllegalStateException(message);
    }
}
