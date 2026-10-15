package com.example.inheritance;

/** Demonstrates extending one class while implementing multiple interfaces. */
public class HybridInheritanceDemo {
    public static void main(String[] args) {
        Consultant consultant = new Consultant("Mina", 600);
        consultant.introduce();
        System.out.println("Identifier: " + consultant.identifier());
        System.out.println("Payment: " + consultant.payment());
    }

    private abstract static class Worker {
        protected final String name;

        protected Worker(String name) {
            this.name = name;
        }

        protected void introduce() {
            System.out.println("Worker: " + name);
        }
    }

    private interface Identifiable {
        String identifier();
    }

    private interface Payable {
        double payment();
    }

    private static final class Consultant extends Worker implements Identifiable, Payable {
        private final double dailyRate;

        private Consultant(String name, double dailyRate) {
            super(name);
            this.dailyRate = dailyRate;
        }

        @Override
        public String identifier() {
            return "CONS-" + name.toUpperCase();
        }

        @Override
        public double payment() {
            return dailyRate * 5;
        }
    }
}
