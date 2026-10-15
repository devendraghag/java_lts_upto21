package com.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Demonstrates writeObject/readObject hooks and restoring transient state. */
public class CustomSerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReportState original = new ReportState("Quarterly report", "Draft saved locally");
        ReportState restored = roundTrip(original);

        System.out.println("Title: " + restored.title);
        System.out.println("Custom transient note: " + restored.note);
    }

    private static ReportState roundTrip(ReportState value)
            throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(value);
        }
        try (ObjectInputStream input = new ObjectInputStream(
                new ByteArrayInputStream(bytes.toByteArray()))) {
            return (ReportState) input.readObject();
        }
    }

    private static class ReportState implements Serializable {
        private static final long serialVersionUID = 1L;

        private String title;
        private transient String note;

        private ReportState(String title, String note) {
            this.title = title;
            this.note = note;
        }

        private void writeObject(ObjectOutputStream output) throws IOException {
            output.defaultWriteObject();
            output.writeObject(note);
        }

        private void readObject(ObjectInputStream input)
                throws IOException, ClassNotFoundException {
            input.defaultReadObject();
            Object value = input.readObject();
            if (!(value instanceof String)) {
                throw new InvalidObjectException("Expected a string secret");
            }
            note = (String) value;
        }
    }
}
