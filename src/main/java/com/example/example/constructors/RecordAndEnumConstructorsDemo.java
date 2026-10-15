package com.example.constructors;

import java.util.Objects;

/** Java 16+ record constructors and enum constructors. */
public class RecordAndEnumConstructorsDemo {
    public static void main(String[] args) {
        System.out.println(new Student("  Asha  ", 20));
        System.out.println(new Student("Ravi"));
        System.out.println("Status: " + OrderStatus.SHIPPED.label());
    }

    private record Student(String name, int age) {
        // Compact canonical constructor validates and normalizes components.
        Student {
            name = Objects.requireNonNull(name, "name").trim();
            if (name.isEmpty() || age < 0) {
                throw new IllegalArgumentException("Name must be nonblank and age non-negative");
            }
        }

        // An additional record constructor delegates to the canonical constructor.
        Student(String name) { this(name, 18); }
    }

    private enum OrderStatus {
        CREATED("Created"), SHIPPED("Shipped"), DELIVERED("Delivered");

        private final String label;
        OrderStatus(String label) { this.label = label; } // Enum constructors are private.
        String label() { return label; }
    }
}
