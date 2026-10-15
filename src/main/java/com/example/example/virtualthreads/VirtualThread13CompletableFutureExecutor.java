package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * JDK 21 introduction-version bucket interview program: CompletableFuture and virtual-thread executors.
 *
 * Program point:
 * - CompletableFuture async methods use the common ForkJoinPool when no executor is supplied.
 * - Pass a virtual-thread executor explicitly when each async task should run in a virtual thread.
 */
/**
 * Easy: Demonstrates Virtual Thread13 Completable Future Executor in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread13CompletableFutureExecutor {
    public static void main(String[] args) {
        CompletableFuture<String> defaultExecutorFuture = CompletableFuture.supplyAsync(() ->
                "Default executor virtual: " + Thread.currentThread().isVirtual());

        try (ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            CompletableFuture<String> virtualExecutorFuture = CompletableFuture.supplyAsync(() ->
                    "Virtual executor virtual: " + Thread.currentThread().isVirtual(), virtualExecutor);

            System.out.println(defaultExecutorFuture.join());
            System.out.println(virtualExecutorFuture.join());
        }
    }
}
