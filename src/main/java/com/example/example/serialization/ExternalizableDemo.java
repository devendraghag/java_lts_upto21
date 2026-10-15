package com.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/** Demonstrates Externalizable, where the class writes and reads its own format. */
public class ExternalizableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Contact original = new Contact("Nora", "nora@example.test");

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(original);
        }

        try (ObjectInputStream input = new ObjectInputStream(
                new ByteArrayInputStream(bytes.toByteArray()))) {
            System.out.println("Restored contact: " + input.readObject());
        }
    }

    public static class Contact implements Externalizable {
        private String name;
        private String email;

        /** Required public no-argument constructor for Externalizable. */
        public Contact() {
        }

        public Contact(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public void writeExternal(ObjectOutput output) throws IOException {
            output.writeUTF(name);
            output.writeUTF(email);
        }

        @Override
        public void readExternal(ObjectInput input) throws IOException {
            name = input.readUTF();
            email = input.readUTF();
        }

        @Override
        public String toString() {
            return "Contact{name='" + name + "', email='" + email + "'}";
        }
    }
}
