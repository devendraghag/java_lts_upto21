package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * JDK 21 BlockingQueue ladder (01/15): ArrayBlockingQueue fundamentals.
 *
 * ArrayBlockingQueue is a fixed-capacity, array-backed, FIFO blocking queue.
 * put() blocks while the queue is full; take() blocks while the queue is empty.
 */
/**
 * Easy: Demonstrates bounded put/take and FIFO ordering on ArrayBlockingQueue.
 * Medium: Track how capacity limits producers and how order is preserved on removal.
 * Tough: Explain why a single-array ring buffer needs one internal lock for both ends.
 */
public class BlockingQueue01ArrayBasicsPutTake {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        queue.put("first");
        queue.put("second");
        queue.put("third");
        //queue.put("fourth"); it will wait to free the space.
        System.out.println("Elements " + queue.size());
        System.out.println("Capacity reached, remaining capacity: " + queue.remainingCapacity());
        System.out.println("Took: " + queue.take());
        System.out.println("Took: " + queue.take());
        System.out.println("Took: " + queue.take());
        System.out.println("Queue empty now, remaining capacity: " + queue.remainingCapacity());
    }
}
