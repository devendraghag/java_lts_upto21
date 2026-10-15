package level03_advanced.jdk17.sealedclasses;

// JDK history: Abstract classes were introduced in JDK 1.0. Sealed and non-sealed classes were previewed in JDK 15 and 16, then finalized in JDK 17.
/**
 * Demonstrates Non Sealed Abstract Class through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class SealedClasses10NonSealedAbstractBranch {
    sealed abstract static class Vehicle permits RoadVehicle {
        abstract void move();
    }

    non-sealed abstract static class RoadVehicle extends Vehicle {
        abstract int wheelCount();
    }

    static class Car extends RoadVehicle {
        @Override
        void move() {
            System.out.println("Car moves on a non-sealed hierarchy branch");
        }

        @Override
        int wheelCount() {
            return 4;
        }
    }

    static class Bus extends RoadVehicle {
        @Override
        void move() {
            System.out.println("Bus moves on the same open branch");
        }

        @Override
        int wheelCount() {
            return 6;
        }
    }

    public static void main(String[] args) {
        RoadVehicle[] vehicles = {new Car(), new Bus()};
        for (RoadVehicle vehicle : vehicles) {
            vehicle.move();
            System.out.println("Wheels: " + vehicle.wheelCount());
        }

        System.out.println("non-sealed is legal only for a direct child of a sealed type.");
    }
}
