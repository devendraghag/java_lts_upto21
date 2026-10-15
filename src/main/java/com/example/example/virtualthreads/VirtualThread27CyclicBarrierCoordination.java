package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * JDK 21 introduction-version bucket interview program: CyclicBarrier with virtual threads.
 *
 * Interview point:
 * - CyclicBarrier synchronizes a fixed number of parties at a common point before any of them proceeds.
 * - Each virtual thread that calls await() parks cheaply until the last party arrives.
 */
/**
 * Easy: Demonstrates Virtual Thread27 Cyclic Barrier Coordination in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread27CyclicBarrierCoordination {
    public static void main(String[] args) {
        int participantCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(participantCount,
                () -> System.out.println("All participants reached the barrier together"));

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= participantCount; i++) {
                int participantId = i;
                executor.submit(() -> {
                    System.out.println("Participant " + participantId + " preparing");
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } catch (BrokenBarrierException e) {
                        System.out.println("Barrier broken for participant " + participantId);
                    }
                    System.out.println("Participant " + participantId + " proceeding past barrier");
                });
            }
        }
    }
}
