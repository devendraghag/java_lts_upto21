package com.example.objectinitialization;

/** Demonstrates JVM default field values and explicit field initializers. */
public class FieldAndDefaultInitializationDemo {
    private static final class Device {
        private String name; // Defaults to null.
        private int year; // Defaults to 0.
        private boolean available; // Defaults to false.
        private String category = "general"; // Explicit field initializer.
    }

    public static void main(String[] args) {
        Device device = new Device();
        System.out.println("name=" + device.name);
        System.out.println("year=" + device.year);
        System.out.println("available=" + device.available);
        System.out.println("category=" + device.category);
    }
}
