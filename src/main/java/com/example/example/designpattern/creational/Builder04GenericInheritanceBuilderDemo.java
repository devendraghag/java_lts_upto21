package com.example.designpattern.creational;

// Generic self type keeps fluent builder methods returning the concrete child builder.
public class Builder04GenericInheritanceBuilderDemo {
    static class Vehicle {
        final String brand;
        Vehicle(Builder<?> builder) { brand = builder.brand; }
        abstract static class Builder<T extends Builder<T>> {
            private String brand;
            T brand(String value) { brand = value; return self(); }
            protected abstract T self();
        }
    }
    static class Car extends Vehicle {
        final int seats;
        private Car(Builder builder) { super(builder); seats = builder.seats; }
        static class Builder extends Vehicle.Builder<Builder> {
            private int seats;
            Builder seats(int value) { seats = value; return this; }
            protected Builder self() { return this; }
            Car build() { return new Car(this); }
        }
        public String toString() { return brand + " car with " + seats + " seats"; }
    }
    public static void main(String[] args) {
        Car car = new Car.Builder().brand("Example Motors").seats(5).build();
        System.out.println(car);
    }
}
