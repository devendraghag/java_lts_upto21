package com.example.objectinitialization;

/** Demonstrates record canonical-constructor initialization and validation (Java 16+). */
public class RecordInitializationDemo {
    private record Temperature(double celsius) {
        private Temperature {
            if (celsius < -273.15) {
                throw new IllegalArgumentException("Temperature is below absolute zero");
            }
        }

        private double fahrenheit() {
            return celsius * 9.0 / 5.0 + 32.0;
        }
    }

    public static void main(String[] args) {
        Temperature temperature = new Temperature(20.0);
        System.out.printf("%.1f C = %.1f F%n", temperature.celsius(), temperature.fahrenheit());
    }
}
