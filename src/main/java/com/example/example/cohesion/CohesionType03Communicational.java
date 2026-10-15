package com.example.cohesion;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Communicational cohesion: operations are grouped because they use or update
 * the same customer record.
 */
public class CohesionType03Communicational {
    static class CustomerRecord {
        private final String customerId;
        private String email;

        CustomerRecord(String customerId, String email) {
            this.customerId = customerId;
            this.email = email;
        }

        boolean hasValidEmail() {
            return email != null && email.contains("@");
        }

        void updateEmail(String newEmail) {
            email = newEmail;
        }

        void printRecord() {
            System.out.println(customerId + " -> " + email);
        }
    }

    public static void main(String[] args) {
        CustomerRecord customer = new CustomerRecord("C-12", "old@example.com");
        System.out.println("Email valid: " + customer.hasValidEmail());
        customer.updateEmail("new@example.com");
        customer.printRecord();
    }
}
