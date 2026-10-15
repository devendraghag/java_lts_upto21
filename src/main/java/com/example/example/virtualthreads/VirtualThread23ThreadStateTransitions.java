package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: observing virtual-thread state transitions.
 *
 * Interview point:
 * - Virtual threads report the same Thread.State values as platform threads (NEW, RUNNABLE, WAITING, TIMED_WAITING, TERMINATED).
 * - Polling getState() from another thread is inherently racy; it is a snapshot, not a guarantee.
 */
/**
 * Easy: Demonstrates Virtual Thread23 Thread State Transitions in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread23ThreadStateTransitions {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread task = Thread.ofVirtual().name("state-watcher").unstarted(() -> {
            synchronized (lock) {
                try {
                    lock.wait(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        System.out.println("New: " + task.getState());

        task.start();
        Thread.sleep(50);
        System.out.println("After start (waiting): " + task.getState());

        task.join();
        System.out.println("Terminated: " + task.getState());
    }
}
