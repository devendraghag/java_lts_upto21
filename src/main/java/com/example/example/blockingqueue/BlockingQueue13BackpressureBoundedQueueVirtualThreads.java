package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * JDK 21 BlockingQueue ladder (13/15): backpressure with a small bounded queue.
 *
 * A tiny bounded queue forces fast virtual-thread producers to block in put() whenever
 * a slow consumer falls behind, capping memory use instead of letting work pile up
 * without limit. This is backpressure applied at the queue boundary.
 */
/**
 * Easy: Demonstrates producers blocking in put() once a small bounded queue fills up.
 * Medium: Track that queue size never exceeds its declared capacity, unlike an unbounded queue.
 * Tough: Explain the tradeoff between bounding the queue (backpressure) versus letting it grow (risking OOM).
 */
public class BlockingQueue13BackpressureBoundedQueueVirtualThreads {

    private static final int CAPACITY = 4;
    private static final int TOTAL_ITEMS = 30;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(CAPACITY);
        AtomicInteger observedMaxSize = new AtomicInteger();

        Thread producer = Thread.ofVirtual().start(() -> {
            for (int i = 1; i <= TOTAL_ITEMS; i++) {
                try {
                    queue.put(i);
                    observedMaxSize.updateAndGet(current -> Math.max(current, queue.size()));
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = Thread.ofVirtual().start(() -> {
            for (int i = 1; i <= TOTAL_ITEMS; i++) {
                try {
                    Thread.sleep(5);
                    queue.take();
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.join();
        consumer.join();

        System.out.println("Bounded capacity: " + CAPACITY);
        System.out.println("Observed max queue size while draining: " + observedMaxSize.get());
        System.out.println("Backpressure held: " + (observedMaxSize.get() <= CAPACITY));
    }
}
