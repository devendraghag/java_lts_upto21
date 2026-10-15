package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * JDK 21 introduction-version bucket interview program: one virtual thread per request simulation.
 *
 * Program point:
 * - A virtual-thread-per-task executor matches the common server style of one task per request.
 * - Blocking request work can remain sequential inside each task while the JVM schedules many virtual threads.
 */
/**
 * Easy: Demonstrates Virtual Thread15 Per Request Simulation in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread15PerRequestSimulation {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int requestId = 1; requestId <= 5; requestId++) {
                int id = requestId;
                executor.submit(() -> handleRequest(id));
            }
        }
    }

    private static void handleRequest(int requestId) {
        try {
            Thread.sleep(200);
            System.out.println("Request " + requestId + " handled by " + Thread.currentThread());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
