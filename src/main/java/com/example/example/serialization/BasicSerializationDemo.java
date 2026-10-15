package com.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Demonstrates a basic Serializable object round trip in memory. */
public class BasicSerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student original = new Student("Mira", 21);
        byte[] data = serialize(original);
        Student restored = (Student) deserialize(data);

        System.out.println("Serialized bytes: " + data.length);
        System.out.println("Restored student: " + restored);
    }

    private static byte[] serialize(Object value) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(value);
        }
        return bytes.toByteArray();
    }

    private static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return input.readObject();
        }
    }

    private static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String name;
        private final int age;

        private Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + "}";
        }
    }
}
