package com.example.abstractclass;

import java.io.IOException;

/** An abstract method may declare checked exceptions for implementations to handle. */
public class AbstractClass15CheckedExceptionDemo {
    public static void main(String[] args) {
        new MemoryStore().save("notes");
    }

    private abstract static class Store {
        public abstract void save(String value) throws IOException;
    }

    private static final class MemoryStore extends Store {
        @Override
        public void save(String value) {
            System.out.println("Saved: " + value);
        }
    }
}
