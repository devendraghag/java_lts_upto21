package com.example.interfaces;

/** Demonstrates a marker interface used to classify a type. */
public class MarkerInterfaceDemo {
    private interface Auditable {
        // Marker interface: intentionally declares no methods.
    }

    private record Invoice(String id, int amountInCents) implements Auditable {
    }

    private static void auditIfRequired(Object value) {
        if (value instanceof Auditable) {
            System.out.println("Auditing " + value);
        } else {
            System.out.println("No audit marker on " + value);
        }
    }

    public static void main(String[] args) {
        auditIfRequired(new Invoice("INV-21", 5200));
        auditIfRequired("ordinary text");
    }
}
