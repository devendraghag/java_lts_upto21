package com.example.collectionclasses.arrayblockingqueue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("job-1");
        queue.offer("job-2");
        queue.offer("job-3", 10, java.util.concurrent.TimeUnit.MILLISECONDS);
        System.out.println("Remaining capacity: " + queue.remainingCapacity());
        System.out.println("Contains job-2: " + queue.contains("job-2"));

        for (String job : queue) {
            System.out.println(job);
        }

        System.out.println("Peek: " + queue.peek());
        ArrayList<String> snapshot = new ArrayList<>(queue);
        System.out.println("ArrayList conversion: " + snapshot);
        System.out.println("Take: " + queue.take());
        System.out.println("Remaining: " + queue);
        queue.drainTo(new ArrayList<>()); // Removes remaining entries into another collection.
        System.out.println("Empty after drainTo: " + queue.isEmpty());
        // ArrayBlockingQueue is FIFO, bounded, and thread-safe; put waits when it is full.
    }
}
