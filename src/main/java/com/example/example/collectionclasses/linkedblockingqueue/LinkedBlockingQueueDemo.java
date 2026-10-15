package com.example.collectionclasses.linkedblockingqueue;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(4);
        queue.offer("task-A");
        queue.put("task-B");
        queue.add("task-C");

        for (String task : queue) {
            System.out.println(task);
        }

        System.out.println("Capacity remaining: " + queue.remainingCapacity());
        System.out.println("ArrayList conversion: " + new ArrayList<>(queue));
        System.out.println("Take: " + queue.take());
        System.out.println("Poll: " + queue.poll()); // Non-blocking retrieval returns null when empty.
        queue.drainTo(new ArrayList<>());
        System.out.println("Empty after drainTo: " + queue.isEmpty());
        // A capacity can be supplied to bound memory; the no-argument constructor is effectively unbounded.
    }
}
