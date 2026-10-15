package com.example.copyonwritearraylist.list;

import java.util.concurrent.CopyOnWriteArrayList;

/** Demonstrates basic CopyOnWriteArrayList operations. */
public class CopyOnWriteArrayList01BasicOperationsDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> topics = new CopyOnWriteArrayList<>();

        // Like most List implementations, it preserves order and allows duplicates.
        topics.add("Java");
        topics.add("Collections");
        topics.add("Java");

        System.out.println("Topics: " + topics);
        System.out.println("Item at index 1: " + topics.get(1));
        System.out.println("First Java index: " + topics.indexOf("Java"));
        System.out.println("Contains Collections: " + topics.contains("Collections"));

        // CopyOnWriteArrayList also permits null elements.
        topics.add(null);
        System.out.println("After adding null: " + topics);
    }
}
