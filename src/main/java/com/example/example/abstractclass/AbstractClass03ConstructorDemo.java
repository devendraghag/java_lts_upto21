package com.example.abstractclass;

/** Abstract classes have constructors; a subclass constructor calls one with super(...). */
public class AbstractClass03ConstructorDemo {
    public static void main(String[] args) {
        Appliance appliance = new Mixer("MX-2");
        appliance.showLabel();
        appliance.run();
    }

    private abstract static class Appliance {
        private final String model;

        protected Appliance(String model) {
            this.model = model;
            System.out.println("Appliance initialized: " + model);
        }

        public final void showLabel() {
            System.out.println("Model: " + model);
        }

        public abstract void run();
    }

    private static final class Mixer extends Appliance {
        private Mixer(String model) {
            super(model);
        }

        @Override
        public void run() {
            System.out.println("Mixer is blending.");
        }
    }
}
