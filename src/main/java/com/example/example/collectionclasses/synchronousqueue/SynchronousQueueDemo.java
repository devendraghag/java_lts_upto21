package com.example.collectionclasses.synchronousqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        List<String> received = new CopyOnWriteArrayList<>();

        Thread producer = new Thread(() -> {
            try {
                queue.put("direct handoff");
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        System.out.println("Queue empty before take: " + queue.isEmpty());

        String message = queue.take();
        received.add(message);
        producer.join();

        System.out.println("Received by consumer:");
        for (String value : received) {
            System.out.println(value);
        }
        System.out.println("ArrayList of received values: " + new ArrayList<>(received));
        System.out.println("Queue size after handoff: " + queue.size());
        System.out.println("Producer alive after join: " + producer.isAlive());
        // SynchronousQueue has no storage: each put must rendezvous directly with a take.
    }
}
