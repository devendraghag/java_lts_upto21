package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: virtual threads and ThreadLocal.
 *
 * Interview point:
 * - Virtual threads support ThreadLocal.
 * - With many virtual threads, large ThreadLocal values can waste memory.
 * - Prefer passing request context explicitly when practical.
 */
/**
 * Easy: Demonstrates Virtual Thread09 Thread Local Usage in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread09ThreadLocalUsage {
    private static final ThreadLocal<String> REQUEST_ID = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread task = Thread.startVirtualThread(() -> {
            REQUEST_ID.set("REQ-101");
            try {
                System.out.println(Thread.currentThread().isVirtual());
                System.out.println("Request: " + REQUEST_ID.get());
            } finally {
                REQUEST_ID.remove();
            }
        });

        task.join();
    }
}
