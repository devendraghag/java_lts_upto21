package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: virtual-thread pinning trap.
 *
 * Interview point:
 * - Keep synchronized blocks short around virtual threads.
 * - Long blocking work inside synchronized can pin a carrier thread.
 */
/**
 * Easy: Demonstrates Virtual Thread17 Pinning Trap in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread17PinningTrap {
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread task = Thread.startVirtualThread(() -> {
            synchronized (LOCK) {
                System.out.println("short synchronized block on virtual thread");
            }
        });

        task.join();
        check(task.isVirtual(), "Expected virtual thread");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
