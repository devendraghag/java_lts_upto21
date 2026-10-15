package level03_advanced.jdk16.records;
// JDK history: Abstract classes were introduced in JDK 1.0. Records were previewed in JDK 14 and 15, then finalized in JDK 16.
/**
 * Demonstrates Records through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class Record27AbstractClassExample {
    interface Describable {
        String description();
    }

    abstract static class Vehicle implements Describable {
        abstract void move();
    }

    static final class Car extends Vehicle {
        private final VehicleData data;

        Car(VehicleData data) {
            this.data = data;
        }

        @Override
        void move() {
            System.out.println(data.model() + " moves");
        }

        @Override
        public String description() {
            return data.description();
        }
    }

    record VehicleData(String model, int year) implements Describable {
        @Override
        public String description() {
            return model + " (" + year + ")";
        }
    }

    // record InvalidVehicle(String model) extends Vehicle { }
    // Compile-time error: a record cannot explicitly extend any class.
    // Every record implicitly extends java.lang.Record and is implicitly final.

    public static void main(String[] args) {
        VehicleData data = new VehicleData("Honda City", 2026);
        Vehicle vehicle = new Car(data);

        vehicle.move();
        System.out.println("Abstract-class view: " + vehicle.description());
        System.out.println("Record view: " + data.description());
        System.out.println("Use a shared interface or composition instead of record inheritance.");
    }
}
