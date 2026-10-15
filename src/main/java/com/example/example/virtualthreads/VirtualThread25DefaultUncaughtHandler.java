package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: default uncaught exception behavior.
 *
 * Interview point:
 * - A directly started virtual thread with no uncaughtExceptionHandler still fails silently to the caller;
 *   the JVM's default handler prints the stack trace to System.err, but join() does not rethrow it.
 * - Contrast this with executor-submitted tasks, where the failure is captured in the Future instead.
 */
/**
 * Easy: Demonstrates Virtual Thread25 Default Uncaught Handler in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread25DefaultUncaughtHandler {
    public static void main(String[] args) throws InterruptedException {
        Thread task = Thread.ofVirtual()
                .name("no-handler-task")
                .start(() -> {
                    throw new RuntimeException("boom - no explicit handler installed");
                });

        task.join();
        System.out.println("Main continues normally even though " + task.getName() + " failed.");
        System.out.println("(See stack trace printed above by the JVM's default uncaught exception handler.)");
    }
}
