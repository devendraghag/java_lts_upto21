package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Abstract classes were introduced in JDK 1.0. Records were previewed in JDK 14 and 15, then finalized in JDK 16. Sealed classes were previewed in JDK 15 and 16, then finalized in JDK 17.
/**
 * Demonstrates Record And Sealed Hierarchy through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class PatternSwitch10RecordSealedHierarchy {
    sealed interface Transport permits Vehicle, VehicleSnapshot { }

    sealed abstract static class Vehicle implements Transport permits Car {
        private final String registration;
        Vehicle(String registration) { this.registration = registration; }
        String registration() { return registration; }
        abstract void move();
    }

    static final class Car extends Vehicle {
        Car(String registration) { super(registration); }
        @Override void move() { System.out.println("Car " + registration() + " moves"); }
    }

    record VehicleSnapshot(String registration, int speed) implements Transport { }

    static String describe(Transport transport) {
        return switch (transport) {
            case Car car -> "Live car " + car.registration();
            case VehicleSnapshot snapshot -> "Snapshot " + snapshot.registration() + " at " + snapshot.speed();
        };
    }

    public static void main(String[] args) {
        Transport live = new Car("KA-01");
        Transport snapshot = new VehicleSnapshot("KA-01", 60);
        ((Car) live).move();
        System.out.println(describe(live));
        System.out.println(describe(snapshot));
        // A record cannot extend Vehicle; it joins the hierarchy through the interface.
    }
}
