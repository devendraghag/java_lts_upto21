package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * JDK 21 BlockingQueue ladder (02/15): non-blocking and timed variants.
 *
 * add() throws when full, offer() returns false instead of blocking,
 * and the timed overloads of offer()/poll() wait up to a deadline before giving up.
 */
/**
 * Easy: Demonstrates add() failing fast versus offer()/poll() timing out gracefully.
 * Medium: Compare the three families: blocking (put/take), timed (offer/poll with timeout), immediate (offer/poll).
 * Tough: Reason about which family to pick under a strict request-latency budget.
 */
public class BlockingQueue02OfferPollTimeout {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        queue.put(100);

        try {
            queue.add(200);
        } catch (IllegalStateException fullQueue) {
            System.out.println("add() on a full queue threw: " + fullQueue.getMessage());
        }

        boolean offered = queue.offer(200);
        System.out.println("Immediate offer() on full queue returned: " + offered);

        boolean offeredWithWait = queue.offer(200, 200, TimeUnit.MILLISECONDS);
        System.out.println("Timed offer() gave up after waiting: " + !offeredWithWait);

        System.out.println("Draining one slot: " + queue.take());
        System.out.println("Timed offer() now succeeds: " + queue.offer(200, 200, TimeUnit.MILLISECONDS));

        queue.take();
        Integer polled = queue.poll(200, TimeUnit.MILLISECONDS);
        System.out.println("Timed poll() on empty queue returned: " + polled);
    }
}
