package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * JDK 21 introduction-version bucket interview program: virtual-thread exception handling.
 *
 * Program point:
 * - An uncaught exception handler can observe failures from directly started virtual threads.
 * - Executor-submitted virtual-thread failures are captured in Future and rethrown from get().
 */
/**
 * Easy: Demonstrates Virtual Thread11 Exception Handling in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread11ExceptionHandling {
    public static void main(String[] args) throws InterruptedException {
        Thread directThread = Thread.ofVirtual()
                .uncaughtExceptionHandler((thread, error) ->
                        System.out.println(thread.getName() + " failed with " + error.getMessage()))
                .name("direct-virtual-task")
                .start(() -> {
                    throw new IllegalStateException("direct failure");
                });

        directThread.join();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var future = executor.submit(() -> {
                throw new IllegalArgumentException("executor failure");
            });

            try {
                future.get();
            } catch (ExecutionException e) {
                System.out.println("Future captured: " + e.getCause().getMessage());
            }
        }
    }
}
