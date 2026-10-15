package com.example.designpattern.creational;

// Enum singleton: Java provides one constant and protects its identity in serialization.
public class Singleton03EnumDemo {
    private enum Registry {
        INSTANCE;

        private final String applicationName = "Interview Prep";

        String getApplicationName() {
            return applicationName;
        }
    }

    public static void main(String[] args) {
        System.out.println(Registry.INSTANCE.getApplicationName());
        System.out.println("Same enum constant: " + (Registry.INSTANCE == Registry.INSTANCE));
    }
}
