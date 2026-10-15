package com.example.designpattern.structural;

// Decorators wrap the same interface and add choices without many combination subclasses.
public class Decorator01CoffeeDemo {
    interface Coffee { String description(); double cost(); }
    static class BasicCoffee implements Coffee {
        public String description() { return "Coffee"; }
        public double cost() { return 2.00; }
    }
    abstract static class CoffeeDecorator implements Coffee {
        protected final Coffee coffee;
        CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
    }
    static class Milk extends CoffeeDecorator {
        Milk(Coffee coffee) { super(coffee); }
        public String description() { return coffee.description() + " + milk"; }
        public double cost() { return coffee.cost() + 0.50; }
    }
    static class Sugar extends CoffeeDecorator {
        Sugar(Coffee coffee) { super(coffee); }
        public String description() { return coffee.description() + " + sugar"; }
        public double cost() { return coffee.cost() + 0.10; }
    }

    public static void main(String[] args) {
        Coffee order = new Sugar(new Milk(new BasicCoffee()));
        System.out.println(order.description() + ": $" + order.cost());
    }
}
