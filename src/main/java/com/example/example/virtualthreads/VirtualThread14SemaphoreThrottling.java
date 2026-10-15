package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 * JDK 21 introduction-version bucket interview program: throttling virtual-thread concurrency.
 *
 * Program point:
 * - Virtual threads are cheap, but external resources such as databases and APIs still need limits.
 * - Semaphore can cap access to a scarce resource while tasks still run as virtual threads.
 */
/**
 * Easy: Demonstrates Virtual Thread14 Semaphore Throttling in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread14SemaphoreThrottling {
    private static final Semaphore DATABASE_CONNECTIONS = new Semaphore(2);

    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int queryId = 1; queryId <= 6; queryId++) {
                int id = queryId;
                executor.submit(() -> runDatabaseQuery(id));
            }
        }
    }

    private static void runDatabaseQuery(int queryId) {
        try {
            DATABASE_CONNECTIONS.acquire();
            try {
                System.out.println("Query " + queryId + " using limited resource");
                Thread.sleep(150);
            } finally {
                DATABASE_CONNECTIONS.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
