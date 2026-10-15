package com.example.covariantreturntype;

/** An overriding method may return a more specific reference type. */
public class CovariantReturnBasicsDemo {
    public static void main(String[] args) {
        Dog specificDog = new Dog("Rex");
        Dog copiedDog = specificDog.copy(); // Statically known return type is Dog.
        System.out.println(copiedDog.name());

        Animal animal = specificDog;
        Animal copiedAnimal = animal.copy(); // Statically known return type is Animal.
        System.out.println(copiedAnimal.getClass().getSimpleName()); // Runtime object is Dog.
    }

    private static class Animal {
        Animal copy() {
            return new Animal();
        }
    }

    private static class Dog extends Animal {
        private final String name;

        Dog(String name) { this.name = name; }

        @Override
        Dog copy() { // Dog is a subtype of the parent's Animal return type.
            return new Dog(name);
        }

        String name() { return name; }
    }
}
