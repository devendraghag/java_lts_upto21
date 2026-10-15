package com.example.abstractclass;

/** Combines shared concrete behavior with a required subclass implementation. */
public class AbstractClass04ConcreteAndAbstractMethodsDemo {
    public static void main(String[] args) {
        TemperatureSensor sensor = new RoomSensor(23.5);
        System.out.println(sensor.readingWithUnit());
    }

    private abstract static class TemperatureSensor {
        public String readingWithUnit() {
            return readCelsius() + " °C";
        }

        protected abstract double readCelsius();
    }

    private static final class RoomSensor extends TemperatureSensor {
        private final double value;

        private RoomSensor(double value) {
            this.value = value;
        }

        @Override
        protected double readCelsius() {
            return value;
        }
    }
}
