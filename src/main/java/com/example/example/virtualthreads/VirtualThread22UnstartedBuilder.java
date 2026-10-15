package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: creating a virtual thread without starting it.
 *
 * Interview point:
 * - Thread.ofVirtual().unstarted(task) builds a Thread in NEW state without scheduling it.
 * - The thread only becomes RUNNABLE once start() is called explicitly.
 * - This is useful when a Thread reference must be prepared before the work should begin.
 */
/**
 * Easy: Demonstrates Virtual Thread22 Unstarted Builder in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread22UnstartedBuilder {
    public static void main(String[] args) throws InterruptedException {
        Thread task = Thread.ofVirtual()
                .name("unstarted-worker")
                .unstarted(() -> System.out.println("Now running: " + Thread.currentThread().getName()));

        System.out.println("Before start, state: " + task.getState());
        task.start();
        System.out.println("Just after start, state: " + task.getState());

        task.join();
        System.out.println("After join, state: " + task.getState());
    }
}
