package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
 * JDK 21 introduction-version bucket interview program: avoiding deadlock between virtual threads.
 *
 * Interview point:
 * - Two virtual threads locking two resources in opposite order can deadlock, exactly like platform threads;
 *   virtual threads add no immunity to classic lock-ordering problems.
 * - tryLock(timeout) lets a thread back off, release what it holds, and retry instead of hanging forever.
 */
/**
 * Advance: Demonstrates Virtual Thread33 Deadlock Avoidance Try Lock in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread33DeadlockAvoidanceTryLock {
    private static final ReentrantLock LOCK_A = new ReentrantLock();
    private static final ReentrantLock LOCK_B = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread first = Thread.ofVirtual().name("acquire-A-then-B")
                .start(() -> acquireBothWithBackoff("first", LOCK_A, LOCK_B));

        Thread second = Thread.ofVirtual().name("acquire-B-then-A")
                .start(() -> acquireBothWithBackoff("second", LOCK_B, LOCK_A));

        first.join();
        second.join();
        System.out.println("Both virtual threads finished without deadlocking");
    }

    private static void acquireBothWithBackoff(String label, ReentrantLock preferred, ReentrantLock secondary) {
        for (int attempt = 1; attempt <= 20; attempt++) {
            boolean gotPreferred = false;
            boolean gotSecondary = false;
            try {
                gotPreferred = preferred.tryLock(20, TimeUnit.MILLISECONDS);
                if (gotPreferred) {
                    gotSecondary = secondary.tryLock(20, TimeUnit.MILLISECONDS);
                    if (gotSecondary) {
                        System.out.println(label + " acquired both locks on attempt " + attempt);
                        return;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } finally {
                if (gotSecondary) {
                    secondary.unlock();
                }
                if (gotPreferred) {
                    preferred.unlock();
                }
            }
            System.out.println(label + " backed off on attempt " + attempt);
        }
    }
}
