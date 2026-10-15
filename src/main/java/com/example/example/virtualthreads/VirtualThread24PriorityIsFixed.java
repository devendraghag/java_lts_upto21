package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: virtual threads ignore priority.
 *
 * Interview point:
 * - Virtual threads always report Thread.NORM_PRIORITY and setPriority(...) is a no-op for them.
 * - Scheduling priority is controlled by the carrier ForkJoinPool, not per virtual thread.
 */
/**
 * Easy: Demonstrates Virtual Thread24 Priority Is Fixed in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread24PriorityIsFixed {
    public static void main(String[] args) throws InterruptedException {
        Thread task = Thread.ofVirtual().unstarted(() -> { });

        System.out.println("Default priority: " + task.getPriority());
        task.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority after setPriority(MAX_PRIORITY): " + task.getPriority());

        task.start();
        task.join();
    }
}
