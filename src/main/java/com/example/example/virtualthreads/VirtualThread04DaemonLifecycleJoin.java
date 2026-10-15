package com.example.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/**
 * Easy: Demonstrates Virtual Thread04 Daemon Lifecycle Join in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread04DaemonLifecycleJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread task = Thread.startVirtualThread(() -> {
            System.out.println("Virtual: " + Thread.currentThread().isVirtual());
            System.out.println("Daemon: " + Thread.currentThread().isDaemon());
        });

        task.join();
        System.out.println("Main waited for the virtual thread to complete");
    }
}