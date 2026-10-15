package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/** Level 8: BlockingDeque supports blocking insertion and removal at both ends. */
public class BlockingQueue08BlockingDeque {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();

        deque.putFirst("urgent");
        deque.putLast("regular");

        System.out.println(deque.takeFirst()); // urgent
        System.out.println(deque.takeLast());  // regular
    }
}