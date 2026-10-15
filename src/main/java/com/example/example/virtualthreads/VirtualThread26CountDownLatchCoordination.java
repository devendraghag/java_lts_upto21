package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * JDK 21 introduction-version bucket interview program: CountDownLatch with virtual threads.
 *
 * Interview point:
 * - CountDownLatch lets one thread wait until several virtual-thread workers finish independent setup work.
 * - Waiting on a latch blocks the calling thread but is cheap when that caller is itself a virtual thread.
 */
/**
 * Easy: Demonstrates Virtual Thread26 Count Down Latch Coordination in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread26CountDownLatchCoordination {
    public static void main(String[] args) throws InterruptedException {
        int workerCount = 4;
        CountDownLatch readyLatch = new CountDownLatch(workerCount);

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= workerCount; i++) {
                int workerId = i;
                executor.submit(() -> {
                    System.out.println("Worker " + workerId + " initializing on " + Thread.currentThread());
                    readyLatch.countDown();
                });
            }

            readyLatch.await();
            System.out.println("All " + workerCount + " workers signalled ready; main proceeds.");
        }
    }
}
