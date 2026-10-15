package com.example.designpattern.creational;

// Synchronized lazy singleton: create on first request while protecting concurrent callers.
public class Singleton03SynchronizedLazyInitialization {
    private static Singleton03SynchronizedLazyInitialization instance;

    private Singleton03SynchronizedLazyInitialization() { }

    public static synchronized Singleton03SynchronizedLazyInitialization getInstance() {
        if (instance == null) { // First caller creates; later callers reuse it.
            instance = new Singleton03SynchronizedLazyInitialization();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance() == getInstance());
    }
}
