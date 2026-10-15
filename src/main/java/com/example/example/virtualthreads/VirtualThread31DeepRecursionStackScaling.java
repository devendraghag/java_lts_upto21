package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/*
 * JDK 21 introduction-version bucket interview program: virtual-thread stacks grow on demand.
 *
 * Interview point:
 * - A platform thread started with a small fixed stack size overflows quickly under deep recursion.
 * - A virtual thread's stack starts small but is stored on the heap and can grow as needed,
 *   so the same recursive call can go noticeably deeper before failing.
 */
/**
 * Advance: Demonstrates Virtual Thread31 Deep Recursion Stack Scaling in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread31DeepRecursionStackScaling {
    public static void main(String[] args) throws InterruptedException {
        int[] platformDepth = new int[1];
        Thread smallStackPlatform = new Thread(null,
                () -> platformDepth[0] = recurse(0),
                "small-stack-platform",
                64 * 1024);
        smallStackPlatform.start();
        smallStackPlatform.join();
        System.out.println("Platform thread with 64KB stack reached depth: " + platformDepth[0]);

        int[] virtualDepth = new int[1];
        Thread virtual = Thread.ofVirtual()
                .name("deep-recursion-virtual")
                .start(() -> virtualDepth[0] = recurse(0));
        virtual.join();
        System.out.println("Virtual thread (default stack policy) reached depth: " + virtualDepth[0]);
    }

    private static int recurse(int depth) {
        try {
            return recurse(depth + 1);
        } catch (StackOverflowError e) {
            return depth;
        }
    }
}
