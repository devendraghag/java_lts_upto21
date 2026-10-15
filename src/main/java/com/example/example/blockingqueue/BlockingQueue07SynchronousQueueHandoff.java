package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * JDK 21 BlockingQueue ladder (07/15): SynchronousQueue direct handoff.
 *
 * SynchronousQueue has zero internal capacity. put() blocks until another thread
 * calls take() at the same moment: every element is a direct producer-to-consumer handoff.
 */
/**
 * Easy: Demonstrates put() blocking until a matching take() arrives, with no buffering.
 * Medium: Track the relative timing between the producer's put() and the consumer's take().
 * Tough: Explain why size() is always 0 and how that differs from every other BlockingQueue here.
 */
public class BlockingQueue07SynchronousQueueHandoff {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>();

        Thread producer = Thread.ofVirtual().start(() -> {
            try {
                System.out.println("Producer: about to put(), will block until a consumer takes it");
                queue.put("handoff-payload");
                System.out.println("Producer: put() returned, handoff completed");
            } catch (InterruptedException interrupted) {
                Thread.currentThread().interrupt();
            }
        });

        Thread.sleep(200);
        System.out.println("Queue size while no consumer has taken yet: " + queue.size());

        Thread consumer = Thread.ofVirtual().start(() -> {
            try {
                String received = queue.take();
                System.out.println("Consumer: received " + received);
            } catch (InterruptedException interrupted) {
                Thread.currentThread().interrupt();
            }
        });

        producer.join();
        consumer.join();
    }
}
