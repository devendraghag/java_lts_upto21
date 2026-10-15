package com.example.generics;

/** Demonstrates generic classes with one and multiple type parameters. */
public class GenericClassDemo {
    private static final class Box<T> {
        private final T value;

        private Box(T value) {
            this.value = value;
        }

        private T get() {
            return value;
        }
    }

    private record Pair<K, V>(K key, V value) {
    }

    public static void main(String[] args) {
        Box<String> message = new Box<>("type-safe value");
        Pair<String, Integer> score = new Pair<>("Maya", 95);

        System.out.println(message.get());
        System.out.println(score.key() + " scored " + score.value());
    }
}
