package com.example.collectionclasses.concurrentlinkedqueue;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("first");
        queue.add("second");
        queue.addAll(java.util.List.of("third", "fourth"));
        System.out.println("Contains third: " + queue.contains("third"));

        for (String value : queue) {
            System.out.println(value);
        }

        System.out.println("Peek: " + queue.peek());
        System.out.println("ArrayList snapshot: " + new ArrayList<>(queue));
        System.out.println("Poll: " + queue.poll());
        System.out.println("Size after poll: " + queue.size());
        queue.removeIf(value -> value.startsWith("f"));
        System.out.println("After removeIf: " + queue);
        // Weakly consistent iterators tolerate concurrent updates; they are not snapshots.
    }
}
