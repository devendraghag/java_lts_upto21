package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Abstract classes and instanceof were introduced in JDK 1.0. Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.
/**
 * Demonstrates Upcasting And Downcasting Matrix through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class PatternMatchingInstanceof09CastingMatrix {
    abstract static class Animal {
        abstract void sound();
    }

    static class Dog extends Animal {
        @Override void sound() { System.out.println("Bark"); }
        void fetch() { System.out.println("Fetching"); }
    }

    static class Cat extends Animal {
        @Override void sound() { System.out.println("Meow"); }
    }

    static void useAnimal(Animal animal) {
        animal.sound();

        if (animal instanceof Dog dog) {
            System.out.println("Safe pattern-matching downcast:");
            dog.fetch();
        } else {
            System.out.println("Object is not a Dog; no downcast performed");
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();

        Animal upcast = dog;       // Implicit and always safe.
        Object widerUpcast = dog;  // Also implicit and safe.
        System.out.println("Upcast runtime type: " + widerUpcast.getClass().getSimpleName());

        Dog safeDowncast = (Dog) upcast;
        safeDowncast.fetch();

        useAnimal(new Dog());
        useAnimal(new Cat());

        Animal catAsAnimal = new Cat();
        try {
            Dog unsafeDowncast = (Dog) catAsAnimal; // Compiles, fails at runtime.
            unsafeDowncast.fetch();
        } catch (ClassCastException exception) {
            System.out.println("Unsafe downcast failed: a Cat object is not a Dog");
        }

        // Dog impossible = upcast; // Compile-time error without an explicit cast.
    }
}
