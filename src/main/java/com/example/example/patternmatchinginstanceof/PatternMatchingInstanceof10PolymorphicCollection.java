package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Abstract classes and instanceof were introduced in JDK 1.0. Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.

import java.util.List;
/**
 * Demonstrates Polymorphic Animal Collection through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class PatternMatchingInstanceof10PolymorphicCollection {
    abstract static class Animal {
        abstract void sound();
        void eat() { System.out.println(getClass().getSimpleName() + " eats"); }
    }

    static class Dog extends Animal {
        @Override void sound() { System.out.println("Dog: Bark"); }
        void fetch() { System.out.println("Dog fetches"); }
    }

    static class Cat extends Animal {
        @Override void sound() { System.out.println("Cat: Meow"); }
        void scratch() { System.out.println("Cat scratches"); }
    }

    static void process(Animal animal) {
        animal.sound();
        animal.eat();

        if (animal instanceof Dog dog) {
            dog.fetch();
        } else if (animal instanceof Cat cat) {
            cat.scratch();
        }
    }

    public static void main(String[] args) {
        List<Animal> animals = List.of(new Dog(), new Cat());
        animals.forEach(PatternMatchingInstanceof10PolymorphicCollection::process);
    }
}
