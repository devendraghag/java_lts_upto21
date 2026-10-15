package com.example.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/**
 * Easy: Demonstrates Virtual Thread03 Is Virtual Flag in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread03IsVirtualFlag {
    public static void main(String[] args) throws Exception {
        Thread thread = Thread.startVirtualThread(() -> System.out.println(Thread.currentThread().isVirtual()));
        thread.join();
    }
}