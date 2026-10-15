package com.example.designpattern.creational;

// Director + builders: a reusable recipe configures different product builders.
public class Builder03DirectorAndConcreteBuildersDemo {
    interface ComputerBuilder {
        void setCpu();
        void setMemory();
        Computer getResult();
    }
    static class Computer {
        String cpu; String memory;
        public String toString() { return cpu + " CPU, " + memory + " memory"; }
    }
    static class GamingComputerBuilder implements ComputerBuilder {
        private final Computer computer = new Computer();
        public void setCpu() { computer.cpu = "High-end"; }
        public void setMemory() { computer.memory = "32 GB"; }
        public Computer getResult() { return computer; }
    }
    static class OfficeComputerBuilder implements ComputerBuilder {
        private final Computer computer = new Computer();
        public void setCpu() { computer.cpu = "Energy-saving"; }
        public void setMemory() { computer.memory = "16 GB"; }
        public Computer getResult() { return computer; }
    }
    static class Director {
        Computer build(ComputerBuilder builder) {
            builder.setCpu(); // The director applies the recipe in a fixed order.
            builder.setMemory();
            return builder.getResult();
        }
    }
    public static void main(String[] args) {
        Director director = new Director();
        System.out.println(director.build(new GamingComputerBuilder()));
        System.out.println(director.build(new OfficeComputerBuilder()));
    }
}
