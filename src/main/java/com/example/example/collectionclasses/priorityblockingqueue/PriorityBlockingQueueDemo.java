package com.example.collectionclasses.priorityblockingqueue;

import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        queue.put(30);
        queue.put(10);
        queue.put(20);
        queue.add(5);
        System.out.println("Head: " + queue.peek());
        System.out.println("Contains 20: " + queue.contains(20));

        for (Integer value : queue) {
            System.out.println("Iterator (not priority order): " + value);
        }

        System.out.println("Snapshot conversion: " + new ArrayList<>(queue));
        System.out.println("Poll order:");
        while (!queue.isEmpty()) {
            System.out.println(queue.take());
        }
        // The queue is logically unbounded; put does not block for capacity.
        // Iterator order is not priority order; take/poll always remove the smallest head.
    }
}
