package level02_intermediate.jdk8.mapdefaultmethods;

import java.util.HashMap;
import java.util.Map;

/*
 * JDK 8 introduction-version bucket interview program: Map.merge() vs Map.compute().
 *
 * Interview point:
 * - merge is concise when combining an incoming value with an existing value.
 * - compute is more general because it sees the key and possibly null old value.
 */
/**
 * Easy: Demonstrates Map Default Methods02 Merge Vs Compute in the Map Default Methods topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict the important state changes and final output before running the program.
 * Tough: Analyze complexity, mutation during iteration, view behavior, and unsupported operations.
 */
public class MapDefaultMethods02MergeVsCompute {
    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();

        counts.merge("java", 1, Integer::sum);
        counts.merge("java", 1, Integer::sum);
        counts.compute("sql", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);

        check(counts.get("java") == 2, "merge count mismatch");
        check(counts.get("sql") == 1, "compute count mismatch");
        System.out.println(counts);
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new IllegalStateException(message);
    }
}
