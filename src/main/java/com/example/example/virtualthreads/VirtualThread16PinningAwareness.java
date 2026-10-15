package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.locks.ReentrantLock;

/*
 * JDK 21 introduction-version bucket interview program: virtual thread pinning awareness.
 *
 * Interview point:
 * - Virtual threads are excellent for blocking I/O workloads.
 * - Long blocking work inside synchronized can pin the virtual thread to a carrier thread.
 * - Prefer keeping synchronized blocks short; for many coordination cases, Lock APIs are clearer.
 */
/**
 * Easy: Demonstrates Virtual Thread16 Pinning Awareness in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread16PinningAwareness {
    private static final Object MONITOR = new Object();
    private static final ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread synchronizedExample = Thread.startVirtualThread(() -> {
            synchronized (MONITOR) {
                System.out.println("Keep synchronized work short: " + Thread.currentThread().isVirtual());
            }
        });

        Thread lockExample = Thread.startVirtualThread(() -> {
            LOCK.lock();
            try {
                System.out.println("Lock API used by virtual thread: " + Thread.currentThread().isVirtual());
            } finally {
                LOCK.unlock();
            }
        });

        synchronizedExample.join();
        lockExample.join();
    }
}
