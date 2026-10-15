package com.example.objectcloning;

import java.util.Arrays;

/**
 * Demonstrates shallow and deep cloning in Java, plus common alternatives.
 * Uses Java SE APIs available through JDK 21; no preview or incubator APIs.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/objectcloning/ObjectCloningExamples.java
 *   java -cp out com.example.objectcloning.ObjectCloningExamples
 */
public class ObjectCloningExamples {
    public static void main(String[] args) throws CloneNotSupportedException {
        shallowClone();
        deepClone();
        arrayClone();
        copyConstructorAlternative();
    }

    private static void shallowClone() throws CloneNotSupportedException {
        System.out.println("== Shallow clone ==");

        ShallowPerson original = new ShallowPerson("Asha", new Address("Pune"));
        ShallowPerson copy = original.clone();

        System.out.println("same top-level object: " + (original == copy));
        System.out.println("same nested Address: " + (original.address == copy.address));
        copy.address.setCity("Mumbai");
        System.out.println("original sees nested change: " + original.address.getCity());

        // super.clone copies primitive fields and reference values. Nested objects
        // are shared until code explicitly copies them.
    }

    private static void deepClone() throws CloneNotSupportedException {
        System.out.println("\n== Deep clone ==");

        DeepPerson original = new DeepPerson("Ravi", new Address("Delhi"));
        DeepPerson copy = original.clone();

        System.out.println("same top-level object: " + (original == copy));
        System.out.println("same nested Address: " + (original.address == copy.address));
        copy.address.setCity("Jaipur");
        System.out.println("original city: " + original.address.getCity());
        System.out.println("copied city: " + copy.address.getCity());
    }

    private static void arrayClone() {
        System.out.println("\n== Array clone ==");

        int[] original = {1, 2, 3};
        int[] copy = original.clone();
        copy[0] = 99;
        System.out.println("primitive arrays copy their values: "
                + Arrays.toString(original) + " / " + Arrays.toString(copy));

        Address[] originalAddresses = {new Address("Chennai")};
        Address[] copiedAddresses = originalAddresses.clone();
        System.out.println("object arrays share element references: "
                + (originalAddresses[0] == copiedAddresses[0]));
    }

    private static void copyConstructorAlternative() {
        System.out.println("\n== Copy constructor alternative ==");

        Address address = new Address("Kochi");
        PersonWithCopyConstructor original = new PersonWithCopyConstructor("Mina", address);
        PersonWithCopyConstructor copy = new PersonWithCopyConstructor(original);
        System.out.println("same nested Address: " + (original.address == copy.address));
        System.out.println("copy: " + copy.name + ", " + copy.address.getCity());
    }

    private static final class ShallowPerson implements Cloneable {
        private final String name;
        private final Address address;

        private ShallowPerson(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        @Override
        public ShallowPerson clone() throws CloneNotSupportedException {
            // Cloneable allows Object.clone() to make the shallow field copy.
            return (ShallowPerson) super.clone();
        }
    }

    private static final class DeepPerson implements Cloneable {
        private final String name;
        private Address address;

        private DeepPerson(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        @Override
        public DeepPerson clone() throws CloneNotSupportedException {
            DeepPerson copy = (DeepPerson) super.clone(); // first make a shallow copy
            copy.address = new Address(address);          // then copy mutable nested state
            return copy;
        }
    }

    private static final class Address {
        private String city;

        private Address(String city) {
            this.city = city;
        }

        private Address(Address other) {
            this.city = other.city;
        }

        private String getCity() {
            return city;
        }

        private void setCity(String city) {
            this.city = city;
        }
    }

    private static final class PersonWithCopyConstructor {
        private final String name;
        private final Address address;

        private PersonWithCopyConstructor(String name, Address address) {
            this.name = name;
            this.address = new Address(address); // explicit independent copy
        }

        private PersonWithCopyConstructor(PersonWithCopyConstructor other) {
            this(other.name, other.address);
        }
    }

    /*
     * Key points:
     * - Object.clone() is protected, so a class normally exposes a public override.
     * - Implement Cloneable or super.clone() throws CloneNotSupportedException.
     * - Cloneable is a marker interface; it does not declare a clone() method.
     * - A deep clone must copy mutable objects reachable from the cloned object,
     *   not just its immediate fields.
     * - Copy constructors or static copy factories are often clearer choices.
     */
}
