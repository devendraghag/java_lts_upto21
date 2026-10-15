package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** Level 1: add and remove elements with blocking queue operations. */
public class BlockingQueue01BasicOperations {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        queue.put("first");
        queue.put("second");
        System.out.println(queue); // [first, second]

        System.out.println(queue.take()); // first
        System.out.println(queue.take()); // second
    }
}