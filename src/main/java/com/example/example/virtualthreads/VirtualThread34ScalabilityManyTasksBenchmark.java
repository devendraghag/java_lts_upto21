package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * JDK 21 introduction-version bucket interview program: scaling to a large number of blocking tasks.
 *
 * Interview point:
 * - Thousands of blocking tasks would exhaust a small platform-thread pool or need a huge one.
 * - A virtual-thread-per-task executor can run all of them concurrently because each blocked
 *   virtual thread only occupies a cheap heap-based stack, not a full OS thread, while parked.
 */
/**
 * Advance: Demonstrates Virtual Thread34 Scalability Many Tasks Benchmark in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread34ScalabilityManyTasksBenchmark {
    private static final int TASK_COUNT = 50_000;
    private static final long PER_TASK_BLOCK_MILLIS = 100;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger completed = new AtomicInteger(0);

        long start = System.nanoTime();
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < TASK_COUNT; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(PER_TASK_BLOCK_MILLIS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    completed.incrementAndGet();
                });
            }
        }
        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;

        System.out.println("Completed tasks: " + completed.get() + " / " + TASK_COUNT);
        System.out.println("Elapsed time: " + elapsedMillis + " ms");
        System.out.println("If each task ran sequentially it would take about "
                + (TASK_COUNT * PER_TASK_BLOCK_MILLIS) + " ms; virtual threads run them concurrently.");
    }
}
