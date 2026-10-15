package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * JDK 21 BlockingQueue ladder (09/15): bulk draining with drainTo().
 *
 * drainTo() removes many elements in one call, avoiding repeated take()/poll() locking
 * overhead. It is commonly used to pull a batch of work for bulk processing.
 */
/**
 * Easy: Demonstrates drainTo() moving all available elements into a plain List in one call.
 * Medium: Track the bounded drainTo(collection, maxElements) overload leaving a remainder behind.
 * Tough: Explain why drainTo() is more efficient than looping poll() under contention.
 */
public class BlockingQueue09DrainToBatch {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.put(i);
        }

        List<Integer> firstBatch = new ArrayList<>();
        int drainedForBatch = queue.drainTo(firstBatch, 4);
        System.out.println("Bounded drainTo() pulled " + drainedForBatch + " elements: " + firstBatch);
        System.out.println("Remaining in queue: " + queue.size());

        List<Integer> rest = new ArrayList<>();
        int drainedTheRest = queue.drainTo(rest);
        System.out.println("Unbounded drainTo() pulled the remaining " + drainedTheRest + " elements: " + rest);
        System.out.println("Queue empty now: " + queue.isEmpty());
    }
}
