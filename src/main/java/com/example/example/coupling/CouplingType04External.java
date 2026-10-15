package com.example.coupling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * External coupling: two modules depend on a format imposed outside them,
 * here a CSV schema with columns in the order orderId,amount.
 */
public class CouplingType04External {
    static class CsvOrderWriter {
        String write(String orderId, double amount) {
            return orderId + "," + amount;
        }
    }

    static class CsvOrderReader {
        String[] read(String line) {
            return line.split(",");
        }
    }

    public static void main(String[] args) {
        String line = new CsvOrderWriter().write("ORD-15", 42.50);
        String[] columns = new CsvOrderReader().read(line);
        System.out.println("External CSV line: " + line);
        System.out.println("Order ID: " + columns[0]);
        System.out.println("Amount: " + columns[1]);
        System.out.println("Changing the shared CSV format requires changing both modules.");
    }
}
