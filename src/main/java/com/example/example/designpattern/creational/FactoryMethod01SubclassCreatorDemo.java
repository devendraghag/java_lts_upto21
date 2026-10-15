package com.example.designpattern.creational;

// Factory Method: subclasses decide which Transport the shared workflow receives.
public class FactoryMethod01SubclassCreatorDemo {
    interface Transport { void deliver(); }

    static class Truck implements Transport {
        public void deliver() { System.out.println("Deliver by road in a truck"); }
    }

    static class Ship implements Transport {
        public void deliver() { System.out.println("Deliver by sea in a ship"); }
    }

    abstract static class Logistics {
        // Factory Method: subclasses supply the concrete product.
        protected abstract Transport createTransport();

        // The workflow stays the same for every logistics type.
        public void planDelivery() {
            Transport transport = createTransport();
            transport.deliver();
        }
    }

    static class RoadLogistics extends Logistics {
        protected Transport createTransport() { return new Truck(); }
    }

    static class SeaLogistics extends Logistics {
        protected Transport createTransport() { return new Ship(); }
    }

    public static void main(String[] args) {
        new RoadLogistics().planDelivery();
        new SeaLogistics().planDelivery();
    }
}
