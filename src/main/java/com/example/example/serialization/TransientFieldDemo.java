package com.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Shows that transient instance state is not included in the default form. */
public class TransientFieldDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Account original = new Account("alex", "do-not-serialize-this");
        Account restored = roundTrip(original);

        System.out.println("User name: " + restored.userName);
        System.out.println("Transient session token: " + restored.sessionToken);
    }

    private static Account roundTrip(Account account) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(account);
        }
        try (ObjectInputStream input = new ObjectInputStream(
                new ByteArrayInputStream(bytes.toByteArray()))) {
            return (Account) input.readObject();
        }
    }

    private static class Account implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String userName;
        private transient String sessionToken;

        private Account(String userName, String sessionToken) {
            this.userName = userName;
            this.sessionToken = sessionToken;
        }
    }
}
