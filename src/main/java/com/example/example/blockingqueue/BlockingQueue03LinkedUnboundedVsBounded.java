package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * JDK 21 BlockingQueue ladder (03/15): LinkedBlockingQueue capacity choices.
 *
 * LinkedBlockingQueue is node-linked rather than array-backed. Without an explicit
 * capacity it defaults to Integer.MAX_VALUE, which behaves as effectively unbounded.
 */
/**
 * Easy: Demonstrates the difference between a capacity-bounded and a default-capacity LinkedBlockingQueue.
 * Medium: Track remainingCapacity() before and after inserts on both queues.
 * Tough: Explain why an "unbounded" queue can still cause OutOfMemoryError under a runaway producer.
 */
public class BlockingQueue03LinkedUnboundedVsBounded {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> bounded = new LinkedBlockingQueue<>(2);
        BlockingQueue<Integer> effectivelyUnbounded = new LinkedBlockingQueue<>();

        bounded.put(1);
        bounded.put(2);
        System.out.println("Bounded queue remaining capacity: " + bounded.remainingCapacity());

        boolean accepted = bounded.offer(3);
        System.out.println("Bounded queue rejected a third element: " + !accepted);

        for (int i = 0; i < 5; i++) {
            effectivelyUnbounded.put(i);
        }
        System.out.println("Unbounded-style queue size: " + effectivelyUnbounded.size());
        System.out.println("Unbounded-style queue remaining capacity: " + effectivelyUnbounded.remainingCapacity());
    }
}
