package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * JDK 21 introduction-version bucket interview program: cancelling a running virtual-thread task.
 *
 * Interview point:
 * - Future.cancel(true) interrupts the virtual thread running the task if it is already in progress.
 * - Long blocking calls such as Thread.sleep respond to that interrupt and unwind through InterruptedException.
 */
/**
 * Medium: Demonstrates Virtual Thread30 Future Cancel Interrupts in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread30FutureCancelInterrupts {
    public static void main(String[] args) throws Exception {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> future = executor.submit(() -> {
                try {
                    Thread.sleep(5_000);
                    return "finished normally";
                } catch (InterruptedException e) {
                    System.out.println("Task observed interruption and is unwinding");
                    throw e;
                }
            });

            Thread.sleep(100);
            boolean cancelled = future.cancel(true);
            System.out.println("cancel(true) returned: " + cancelled);

            try {
                future.get();
            } catch (CancellationException e) {
                System.out.println("future.get() reports the task was cancelled");
            }
        }
    }
}
