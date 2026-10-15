package com.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Uses the serialization-proxy pattern to validate and rebuild an object. */
public class SerializationProxyDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Money restored = roundTrip(new Money(1_299, "USD"));
        System.out.println("Restored value: " + restored);
    }

    private static Money roundTrip(Money value) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(value);
        }
        try (ObjectInputStream input = new ObjectInputStream(
                new ByteArrayInputStream(bytes.toByteArray()))) {
            return (Money) input.readObject();
        }
    }

    private static class Money implements Serializable {
        private static final long serialVersionUID = 1L;

        private final long minorUnits;
        private final String currency;

        private Money(long minorUnits, String currency) {
            if (minorUnits < 0 || currency == null || !currency.matches("[A-Z]{3}")) {
                throw new IllegalArgumentException("Invalid amount or currency code");
            }
            this.minorUnits = minorUnits;
            this.currency = currency;
        }

        private Object writeReplace() {
            return new SerializationProxy(minorUnits, currency);
        }

        private void readObject(ObjectInputStream input)
                throws IOException, ClassNotFoundException {
            throw new InvalidObjectException("Serialization proxy required");
        }

        @Override
        public String toString() {
            return currency + " " + minorUnits + " minor units";
        }
    }

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 1L;

        private final long minorUnits;
        private final String currency;

        private SerializationProxy(long minorUnits, String currency) {
            this.minorUnits = minorUnits;
            this.currency = currency;
        }

        private Object readResolve() {
            return new Money(minorUnits, currency);
        }
    }
}
