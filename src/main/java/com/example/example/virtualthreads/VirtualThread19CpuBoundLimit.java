package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.Executors;

/*
 * JDK 21 introduction-version bucket interview program: virtual threads and CPU-bound work.
 *
 * Interview point:
 * - Virtual threads help most when tasks block on I/O.
 * - They do not add CPU cores and do not automatically speed up CPU-heavy loops.
 */
/**
 * Easy: Demonstrates Virtual Thread19 Cpu Bound Limit in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread19CpuBoundLimit {
    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var future = executor.submit(() -> {
                long sum = 0;
                for (int i = 1; i <= 1_000_000; i++) {
                    sum += i;
                }
                return sum;
            });

            System.out.println("CPU result: " + future.get());
        }
    }
}
