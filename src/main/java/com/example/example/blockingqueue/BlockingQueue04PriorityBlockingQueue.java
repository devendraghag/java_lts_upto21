package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/** Level 4: PriorityBlockingQueue removes elements by priority, not insertion order. */
public class BlockingQueue04PriorityBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        queue.add(30);
        queue.add(10);
        queue.add(20);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove()); // 10, then 20, then 30
        }
    }
}