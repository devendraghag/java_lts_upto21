package com.example.inheritance;

/** Demonstrates one class extending one parent class. */
public class SingleInheritanceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("Milo");
        dog.eat();       // Inherited method.
        dog.makeSound(); // Overridden method.
    }

    private static class Animal {
        protected final String name;

        protected Animal(String name) {
            this.name = name;
        }

        protected void eat() {
            System.out.println(name + " is eating.");
        }

        protected void makeSound() {
            System.out.println("Animal sound");
        }
    }

    private static final class Dog extends Animal {
        private Dog(String name) {
            super(name);
        }

        @Override
        protected void makeSound() {
            System.out.println(name + " says woof.");
        }
    }
}
