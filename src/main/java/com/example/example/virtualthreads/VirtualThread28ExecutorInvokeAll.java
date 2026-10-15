package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * JDK 21 introduction-version bucket interview program: invokeAll with a virtual-thread executor.
 *
 * Interview point:
 * - invokeAll submits every task and blocks until all of them complete, returning Futures in submission order.
 * - Because each task runs on its own virtual thread, slow tasks do not starve others of a worker thread.
 */
/**
 * Medium: Demonstrates Virtual Thread28 Executor Invoke All in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread28ExecutorInvokeAll {
    public static void main(String[] args) throws Exception {
        List<Callable<Integer>> tasks = List.of(
                () -> slowSquare(2, 150),
                () -> slowSquare(3, 50),
                () -> slowSquare(4, 100)
        );

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<Integer>> results = executor.invokeAll(tasks);
            for (Future<Integer> result : results) {
                System.out.println("Result: " + result.get());
            }
        }
    }

    private static int slowSquare(int value, long delayMillis) throws InterruptedException {
        Thread.sleep(delayMillis);
        return value * value;
    }
}
