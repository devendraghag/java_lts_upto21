package com.example.stringbuilder;

/** Demonstrates StringBuilder creation, mutation, length, and capacity. */
public class StringBuilderBasicsDemo {
    public static void main(String[] args) {
        StringBuilder empty = new StringBuilder();
        System.out.println("Default length/capacity: " + empty.length() + "/" + empty.capacity());

        StringBuilder message = new StringBuilder("Java");
        message.append(" StringBuilder");
        System.out.println("Value: " + message);
        System.out.println("Length: " + message.length());
        System.out.println("Capacity: " + message.capacity());

        StringBuilder sized = new StringBuilder(40);
        sized.append("Pre-sized buffer");
        sized.ensureCapacity(100);
        System.out.println("Capacity after ensureCapacity: " + sized.capacity());
        sized.trimToSize();
        System.out.println("Capacity after trimToSize: " + sized.capacity());

        String immutableResult = message.toString();
        System.out.println("Converted to String: " + immutableResult);
    }
}
