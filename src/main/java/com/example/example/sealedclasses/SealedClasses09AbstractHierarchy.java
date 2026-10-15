package level03_advanced.jdk17.sealedclasses;
// JDK history: Abstract classes were introduced in JDK 1.0. Sealed classes were previewed in JDK 15 and 16, then finalized in JDK 17.
/**
 * Demonstrates Sealed Hierarchy through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class SealedClasses09AbstractHierarchy {
    sealed abstract static class Vehicle permits Car, CommercialVehicle {
        abstract void move();
    }
    static final class Car extends Vehicle {
        @Override void move() { System.out.println("Final permitted Car moves"); }
    }
    static non-sealed abstract class CommercialVehicle extends Vehicle { }
    static class Truck extends CommercialVehicle {
        @Override void move() { System.out.println("Truck extends non-sealed branch"); }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {new Car(), new Truck()};
        for (Vehicle vehicle : vehicles) vehicle.move();
    }
}
