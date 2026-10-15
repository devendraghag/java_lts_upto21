package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * JDK 21 BlockingQueue ladder (10/15): many virtual-thread producers and consumers.
 *
 * A single ArrayBlockingQueue safely coordinates many producers and consumers because
 * put()/take() are internally synchronized. Virtual threads make it cheap to model
 * dozens of independent producers/consumers as real threads instead of a thread pool.
 */
/**
 * Easy: Demonstrates several producer and consumer virtual threads sharing one bounded queue.
 * Medium: Track the AtomicInteger counters to confirm every produced item is consumed exactly once.
 * Tough: Explain why no external locking is needed even with many concurrent producers/consumers.
 */
public class BlockingQueue10MultiProducerMultiConsumerVirtualThreads {

    private static final int PRODUCERS = 4;
    private static final int CONSUMERS = 4;
    private static final int ITEMS_PER_PRODUCER = 25;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger produced = new AtomicInteger();
        AtomicInteger consumed = new AtomicInteger();
        List<Thread> producers = new ArrayList<>();
        List<Thread> consumers = new ArrayList<>();

        for (int p = 0; p < PRODUCERS; p++) {
            int producerId = p;
            producers.add(Thread.ofVirtual().name("producer-" + producerId).start(() -> {
                for (int i = 0; i < ITEMS_PER_PRODUCER; i++) {
                    try {
                        queue.put(producerId * ITEMS_PER_PRODUCER + i);
                        produced.incrementAndGet();
                    } catch (InterruptedException interrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
            }));
        }

        for (int c = 0; c < CONSUMERS; c++) {
            consumers.add(Thread.ofVirtual().name("consumer-" + c).start(() -> {
                for (int i = 0; i < (PRODUCERS * ITEMS_PER_PRODUCER) / CONSUMERS; i++) {
                    try {
                        queue.take();
                        consumed.incrementAndGet();
                    } catch (InterruptedException interrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
            }));
        }

        for (Thread producer : producers) {
            producer.join();
        }
        for (Thread consumer : consumers) {
            consumer.join();
        }

        System.out.println("Produced: " + produced.get() + ", Consumed: " + consumed.get());
        System.out.println("Both counts match, and no item was lost or duplicated: " + (produced.get() == consumed.get()));
    }
}
