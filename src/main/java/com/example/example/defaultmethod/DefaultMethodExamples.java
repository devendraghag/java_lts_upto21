package com.example.defaultmethod;

/**
 * Demonstrates Java interface default methods and their inheritance rules
 * through JDK 21. Default methods became available in JDK 8; private interface
 * helpers became available in JDK 9. No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/defaultmethod/DefaultMethodExamples.java
 *   java -cp out com.example.defaultmethod.DefaultMethodExamples
 */
public class DefaultMethodExamples {
    public static void main(String[] args) {
        inheritedDefault();
        overriddenDefault();
        classMethodTakesPrecedence();
        mostSpecificInterfaceDefault();
        resolveUnrelatedDefaults();
        defaultMethodWithPrivateHelper();
    }

    private static void inheritedDefault() {
        System.out.println("== Inherit a default method ==");

        Device basicDevice = new BasicDevice();
        basicDevice.status(); // implementation comes from the interface
    }

    private static void overriddenDefault() {
        System.out.println("\n== Override a default method ==");

        Device advancedDevice = new AdvancedDevice();
        advancedDevice.status();
    }

    private static void classMethodTakesPrecedence() {
        System.out.println("\n== Class method takes precedence over an interface default ==");

        Device device = new ClassDevice();
        device.status(); // inherited class method is used instead of the default
    }

    private static void mostSpecificInterfaceDefault() {
        System.out.println("\n== Most-specific interface default wins ==");

        new FriendlyDevice().greet();
    }

    private static void resolveUnrelatedDefaults() {
        System.out.println("\n== Resolve conflicting defaults from unrelated interfaces ==");

        new CombinedDevice().identify();
    }

    private static void defaultMethodWithPrivateHelper() {
        System.out.println("\n== Default method using a private interface helper (JDK 9+) ==");

        new AuditedService().audit("  Build Report  ");
    }

    private interface Device {
        default void status() {
            System.out.println("Device is ready (interface default)");
        }
    }

    private static final class BasicDevice implements Device {
        // No status() override: the default implementation is inherited.
    }

    private static final class AdvancedDevice implements Device {
        @Override
        public void status() {
            System.out.println("Advanced device performs a self-check");
        }
    }

    private static class BaseDevice {
        public void status() {
            System.out.println("BaseDevice class method");
        }
    }

    private static final class ClassDevice extends BaseDevice implements Device {
        // The inherited class method wins over Device.status().
    }

    private interface Greeting {
        default void greet() {
            System.out.println("Hello");
        }
    }

    private interface FriendlyGreeting extends Greeting {
        @Override
        default void greet() {
            System.out.println("Hello, friend");
        }
    }

    private static final class FriendlyDevice implements FriendlyGreeting {
        // The more-specific FriendlyGreeting default is inherited.
    }

    private interface LeftIdentity {
        default void identify() {
            System.out.println("Left identity");
        }
    }

    private interface RightIdentity {
        default void identify() {
            System.out.println("Right identity");
        }
    }

    private static final class CombinedDevice implements LeftIdentity, RightIdentity {
        @Override
        public void identify() {
            LeftIdentity.super.identify(); // explicitly select one parent default
            RightIdentity.super.identify();
            System.out.println("Combined identity");
        }
    }

    private interface Auditable {
        default void audit(String message) {
            System.out.println("Audit: " + normalize(message));
        }

        // Private interface methods can share code among default methods.
        private String normalize(String value) {
            return value.strip().toLowerCase();
        }
    }

    private static final class AuditedService implements Auditable { }

    /*
     * Rules and notes:
     * - A class may inherit defaults from multiple interfaces.
     * - A class implementation takes precedence over an interface default.
     * - A subinterface's override takes precedence over its parent interface default.
     * - If unrelated interfaces provide the same default signature, the class must
     *   override it and can call a selected implementation with InterfaceName.super.method().
     * - Interface static methods are called on the interface and are not defaults.
     * - Default methods cannot replace public methods declared by Object (such as equals).
     */
}
