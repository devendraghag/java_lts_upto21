package com.example.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.ThreadFactory;

/**
 * Easy: Demonstrates Virtual Thread02 Builder And Naming in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread02BuilderAndNaming {
    public static void main(String[] args) throws Exception {
        Thread namedThread = Thread.ofVirtual()
                .name("worker-", 1)
                .start(() -> System.out.println(Thread.currentThread().getName()));

        ThreadFactory factory = Thread.ofVirtual()
                .name("factory-worker-", 10) // 10 is starting number of thread.
                .factory();

        Thread factoryThread = factory.newThread(() ->
                System.out.println(Thread.currentThread().getName()));
        factoryThread.start();

        Thread factoryThread1 = factory.newThread(() ->
                System.out.println(Thread.currentThread().getName()));
        factoryThread1.start();


        Thread factoryThread2 = factory.newThread(() ->
                System.out.println(Thread.currentThread().getName()));
        factoryThread2.start();

        namedThread.join();
        factoryThread.join();
        factoryThread1.join();
        factoryThread2.join();
    }
}
