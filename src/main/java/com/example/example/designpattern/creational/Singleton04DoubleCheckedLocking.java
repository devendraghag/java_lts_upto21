package com.example.designpattern.creational;

// Double-checked locking: volatile plus two checks makes lazy creation thread-safe.
public class Singleton04DoubleCheckedLocking {
    private static volatile Singleton04DoubleCheckedLocking instance;

    private Singleton04DoubleCheckedLocking() { }

    public static Singleton04DoubleCheckedLocking getInstance() {
        if (instance == null) { // Fast check: most calls skip synchronization.
            synchronized (Singleton04DoubleCheckedLocking.class) {
                if (instance == null) { // Recheck after acquiring the lock.
                    instance = new Singleton04DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance() == getInstance());
    }
}
