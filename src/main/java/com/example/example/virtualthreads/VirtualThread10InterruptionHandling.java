package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: virtual-thread interruption.
 *
 * Program point:
 * - Virtual threads follow the same interruption model as platform threads.
 * - Blocking operations such as sleep can throw InterruptedException and should restore the interrupt status when needed.
 */
/**
 * Easy: Demonstrates Virtual Thread10 Interruption Handling in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread10InterruptionHandling {
    public static void main(String[] args) throws InterruptedException {
        Thread task = Thread.startVirtualThread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Completed without interruption");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Interrupted virtual thread: " + Thread.currentThread().isInterrupted());
            }
        });

        Thread.sleep(100);
        System.out.println("before interrupted");
        task.interrupt();
        System.out.println("after interrupted");
        task.join();
    }
}
