package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: virtual-thread diagnostics basics.
 *
 * Interview point:
 * - Thread dumps can include many virtual threads.
 * - Naming virtual threads helps identify request/task ownership.
 * - Thread.currentThread().isVirtual() confirms the thread kind.
 */
/**
 * Easy: Demonstrates Virtual Thread18 Diagnostics Basics in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread18DiagnosticsBasics {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.ofVirtual()
                .name("order-worker-", 1)
                .start(() -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Virtual: " + Thread.currentThread().isVirtual());
                });

        thread.join();
    }
}
