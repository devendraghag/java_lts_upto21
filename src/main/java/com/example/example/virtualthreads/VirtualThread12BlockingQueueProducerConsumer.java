package level03_advanced.jdk21.virtualthreads;
// JDK history: Virtual threads were previewed in JDK 19 and 20, then finalized in JDK 21. The preview-only Thread.Builder.allowSetThreadLocals option was dropped before finalization.

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * JDK 21 introduction-version bucket interview program: virtual threads with blocking queues.
 *
 * Program point:
 * - A virtual thread can wait on BlockingQueue operations without occupying an OS thread for the full wait.
 * - This keeps the producer-consumer style readable while supporting many waiting tasks.
 */
/**
 * Easy: Demonstrates Virtual Thread12 Blocking Queue Producer Consumer in the Virtual Threads topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class VirtualThread12BlockingQueueProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Thread consumer = Thread.startVirtualThread(() -> {
            try {
                System.out.println("Consumed: " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread producer = Thread.startVirtualThread(() -> {
            try {
                queue.put("message-from-producer");
                System.out.println("Produced by virtual thread");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.join();
        consumer.join();
    }
}
