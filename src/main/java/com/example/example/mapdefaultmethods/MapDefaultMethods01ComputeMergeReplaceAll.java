package level02_intermediate.jdk8.mapdefaultmethods;

import java.util.HashMap;
import java.util.Map;

/*
 * JDK 8 introduction-version bucket interview program: Map default methods.
 *
 * Interview point:
 * - computeIfAbsent initializes missing values.
 * - computeIfPresent updates existing values.
 * - compute, merge, and replaceAll express common mutation patterns atomically per map call.
 */
/**
 * Easy: Demonstrates Map Default Methods01 Compute Merge Replace All in the Map Default Methods topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict the important state changes and final output before running the program.
 * Tough: Analyze complexity, mutation during iteration, view behavior, and unsupported operations.
 */
public class MapDefaultMethods01ComputeMergeReplaceAll {
    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();

        counts.computeIfAbsent("java", key -> 1);
        counts.computeIfPresent("java", (key, value) -> value + 1);
        counts.compute("sql", (key, value) -> value == null ? 1 : value + 1);
        counts.merge("java", 3, Integer::sum);
        counts.replaceAll((key, value) -> value * 10);

        check(counts.get("java") == 50, "Map default methods java mismatch");
        check(counts.get("sql") == 10, "Map default methods sql mismatch");
        System.out.println(counts);
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new IllegalStateException(message);
    }
}
