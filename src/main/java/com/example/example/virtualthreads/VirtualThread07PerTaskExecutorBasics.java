package com.example.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Easy: Demonstrates Virtual Thread07 Per Task Executor Basics in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread07PerTaskExecutorBasics {
    public static void main(String[] args) throws Exception {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> System.out.println("task"));
        }
    }
}