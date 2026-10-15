package com.example.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

/**
 * Easy: Demonstrates Virtual Thread06 Many Virtual Threads in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread06ManyVirtualThreads {
    public static void main(String[] args) throws Exception {
        //option 1
        java.util.List<Thread> threads = new java.util.ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            threads.add(Thread.startVirtualThread(() -> System.out.println(Thread.currentThread())));
        }
        for (Thread thread : threads)
        {
            thread.join();
        }
    }

// option 2
    Thread manyThread = Thread.ofVirtual()
            .name("worker-", 20)
            .start(() -> System.out.println(Thread.currentThread().getName()));

    //both way we can create many virtual threads, but option 1 is more flexible and allows us to create a dynamic number of threads based on the loop condition. Option 2 is more static and creates a fixed number of threads with a specific naming pattern.
}
