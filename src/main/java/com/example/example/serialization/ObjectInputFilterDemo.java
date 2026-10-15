package com.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Demonstrates an allow-list and resource limits for object deserialization. */
public class ObjectInputFilterDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] data = serialize(new Message("Hello from a filtered stream"));
        try (ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(data))) {
            input.setObjectInputFilter(ObjectInputFilterDemo::filter);
            Message message = (Message) input.readObject();
            System.out.println("Accepted message: " + message.text);
        }
    }

    private static ObjectInputFilter.Status filter(ObjectInputFilter.FilterInfo info) {
        if (info.depth() > 10 || info.references() > 100 || info.streamBytes() > 100_000) {
            return ObjectInputFilter.Status.REJECTED;
        }

        Class<?> type = info.serialClass();
        if (type == null) {
            return ObjectInputFilter.Status.UNDECIDED;
        }
        if (type == Message.class || type == String.class) {
            return ObjectInputFilter.Status.ALLOWED;
        }
        return ObjectInputFilter.Status.REJECTED;
    }

    private static byte[] serialize(Object value) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(value);
        }
        return bytes.toByteArray();
    }

    private static class Message implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String text;

        private Message(String text) {
            this.text = text;
        }
    }
}
