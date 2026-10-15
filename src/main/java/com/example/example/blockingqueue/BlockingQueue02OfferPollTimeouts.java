package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/** Level 2: compare immediate and timed queue operations. */
public class BlockingQueue02OfferPollTimeouts {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        System.out.println(queue.offer("A")); // true
        System.out.println(queue.offer("B")); // false: full, so this does not wait
        System.out.println(queue.peek());     // A

        System.out.println(queue.poll()); // A; returns immediately
        System.out.println(queue.offer("B", 100, TimeUnit.MILLISECONDS)); // true
        System.out.println(queue.poll(100, TimeUnit.MILLISECONDS));       // B
    }
}