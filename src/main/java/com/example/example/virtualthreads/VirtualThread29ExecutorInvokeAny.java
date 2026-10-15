package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * JDK 21 introduction-version bucket interview program: invokeAny with a virtual-thread executor.
 *
 * Interview point:
 * - invokeAny returns the result of the first task to complete successfully and cancels the rest.
 * - This models a "fastest wins" fan-out call to redundant sources, cheap to do with virtual threads.
 */
/**
 * Medium: Demonstrates Virtual Thread29 Executor Invoke Any in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread29ExecutorInvokeAny {
    public static void main(String[] args) throws Exception {
        List<Callable<String>> mirrors = List.of(
                () -> fetchFrom("mirror-A", 200),
                () -> fetchFrom("mirror-B", 50),
                () -> fetchFrom("mirror-C", 300)
        );

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            String fastestResult = executor.invokeAny(mirrors);
            System.out.println("Fastest response: " + fastestResult);
        }
    }

    private static String fetchFrom(String source, long delayMillis) throws InterruptedException {
        Thread.sleep(delayMillis);
        return "data from " + source;
    }
}
