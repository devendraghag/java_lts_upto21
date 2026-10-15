package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * JDK 21 introduction-version bucket interview program: data race across many virtual threads.
 *
 * Interview point:
 * - Cheap virtual threads make it easy to fan out thousands of concurrent increments,
 *   which also makes a non-atomic "read-modify-write" race easy to expose.
 * - AtomicInteger.incrementAndGet fixes the race without needing a lock.
 */
/**
 * Advance: Demonstrates Virtual Thread32 Race Condition Atomic Fix in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread32RaceConditionAtomicFix {
    private static int unsafeCounter = 0;
    private static final AtomicInteger SAFE_COUNTER = new AtomicInteger(0);
    private static final int INCREMENTS = 10_000;

    public static void main(String[] args) throws InterruptedException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < INCREMENTS; i++) {
                executor.submit(() -> {
                    unsafeCounter++;
                    SAFE_COUNTER.incrementAndGet();
                });
            }
        }

        System.out.println("Expected: " + INCREMENTS);
        System.out.println("Unsafe counter (racy ++): " + unsafeCounter);
        System.out.println("Safe counter (AtomicInteger): " + SAFE_COUNTER.get());
    }
}
