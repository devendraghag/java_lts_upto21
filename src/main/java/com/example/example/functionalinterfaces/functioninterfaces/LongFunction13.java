package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function13 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction13 {
    public static void main(String[] args) {

        Map<Long, String> cache = new HashMap<>();

        // Caches computation result
        LongFunction<String> cachedMapper =
                l -> cache.computeIfAbsent(l, k -> "Cached-" + k);

        System.out.println(cachedMapper.apply(5L));
        System.out.println(cachedMapper.apply(5L)); // cached
    }
}
