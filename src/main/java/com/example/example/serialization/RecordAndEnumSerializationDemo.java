package com.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Demonstrates serializing a record and an enum. Records became final in JDK 16. */
public class RecordAndEnumSerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Customer customer = roundTrip(new Customer("Ravi", "ravi@example.test", Status.ACTIVE));
        Status status = roundTrip(Status.ACTIVE);

        System.out.println("Record: " + customer);
        System.out.println("Enum: " + status);
    }

    @SuppressWarnings("unchecked")
    private static <T> T roundTrip(T value) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(value);
        }
        try (ObjectInputStream input = new ObjectInputStream(
                new ByteArrayInputStream(bytes.toByteArray()))) {
            return (T) input.readObject();
        }
    }

    private record Customer(String name, String email, Status status) implements Serializable {
        private Customer {
            if (name == null || email == null || status == null) {
                throw new IllegalArgumentException("Customer fields must not be null");
            }
        }
    }

    private enum Status {
        ACTIVE,
        INACTIVE
    }
}
