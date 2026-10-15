package com.example.designpattern.behavioral;

// Template Method: the parent fixes the recipe order; subclasses fill in selected steps.
public class TemplateMethod01BeverageDemo {
    abstract static class Beverage {
        // final keeps subclasses from changing the overall algorithm order.
        public final void prepare() {
            boilWater(); brew(); pourInCup(); addExtras();
        }
        private void boilWater() { System.out.println("Boil water"); }
        protected abstract void brew();
        private void pourInCup() { System.out.println("Pour into cup"); }
        protected abstract void addExtras();
    }
    static class Tea extends Beverage {
        protected void brew() { System.out.println("Steep tea leaves"); }
        protected void addExtras() { System.out.println("Add lemon"); }
    }
    static class Coffee extends Beverage {
        protected void brew() { System.out.println("Brew coffee grounds"); }
        protected void addExtras() { System.out.println("Add milk"); }
    }

    public static void main(String[] args) {
        new Tea().prepare();
        new Coffee().prepare();
    }
}
