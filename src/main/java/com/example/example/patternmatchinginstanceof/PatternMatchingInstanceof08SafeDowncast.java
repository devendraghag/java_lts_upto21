package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Abstract classes and instanceof were introduced in JDK 1.0. Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.
/**
 * Demonstrates Safe Downcasting through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class PatternMatchingInstanceof08SafeDowncast {
    abstract static class Vehicle { abstract void move(); }
    static class Car extends Vehicle {
        @Override void move() { System.out.println("Car moves"); }
        void openBoot() { System.out.println("Car boot opened"); }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        if (vehicle instanceof Car car) {
            car.move();
            car.openBoot();
        }
    }
}
