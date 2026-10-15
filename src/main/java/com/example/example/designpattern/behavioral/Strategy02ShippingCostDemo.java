package com.example.designpattern.behavioral;

// Strategy can also vary a calculation while the caller keeps one stable operation.
public class Strategy02ShippingCostDemo {
    interface ShippingStrategy { double cost(double weightKg); }
    static class StandardShipping implements ShippingStrategy {
        public double cost(double weightKg) { return 40 + 10 * weightKg; }
    }
    static class ExpressShipping implements ShippingStrategy {
        public double cost(double weightKg) { return 100 + 20 * weightKg; }
    }
    static class ShippingCalculator {
        double calculate(ShippingStrategy strategy, double weight) { return strategy.cost(weight); }
    }

    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator();
        System.out.println("Standard: " + calculator.calculate(new StandardShipping(), 2));
        System.out.println("Express: " + calculator.calculate(new ExpressShipping(), 2));
    }
}
