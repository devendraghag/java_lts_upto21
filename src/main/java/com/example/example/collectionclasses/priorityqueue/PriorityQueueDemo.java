package com.example.collectionclasses.priorityqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> values = new PriorityQueue<>();
        values.offer(30);
        values.offer(10);
        values.offer(20);
        values.addAll(java.util.List.of(40, 5));
        System.out.println("Contains 20: " + values.contains(20));

        System.out.println("Head: " + values.peek());
        for (Integer value : values) {
            System.out.println("Iterator order (not guaranteed sorted): " + value);
        }

        System.out.println("ArrayList conversion: " + new ArrayList<>(values));
        System.out.println("Priority order by polling:");
        while (!values.isEmpty()) {
            System.out.println(values.poll());
        }
        values.clear(); // Safe even when already empty; removes all queued elements.
        System.out.println("Empty after clear: " + values.isEmpty());
        // PriorityQueue iterator order is not sorted; it has no JDK 21 sequenced view.
    }
}
