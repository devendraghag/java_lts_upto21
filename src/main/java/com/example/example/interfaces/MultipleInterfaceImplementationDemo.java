package com.example.interfaces;

/** Demonstrates a class implementing multiple interfaces. */
public class MultipleInterfaceImplementationDemo {
    private interface Flyable {
        void fly();
    }

    private interface Swimmable {
        void swim();
    }

    private static final class Duck implements Flyable, Swimmable {
        @Override
        public void fly() {
            System.out.println("Duck flies");
        }

        @Override
        public void swim() {
            System.out.println("Duck swims");
        }
    }

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
    }
}
