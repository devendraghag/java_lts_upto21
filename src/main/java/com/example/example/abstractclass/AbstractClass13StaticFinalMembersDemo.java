package com.example.abstractclass;

/** Abstract classes may also declare static and final members. */
public class AbstractClass13StaticFinalMembersDemo {
    public static void main(String[] args) {
        System.out.println(Worker.category());
        Worker worker = new Developer("Asha");
        worker.printName();
        worker.work();
    }

    private abstract static class Worker {
        private final String name;

        protected Worker(String name) { this.name = name; }
        public static String category() { return "Employees"; }
        public final void printName() { System.out.println("Name: " + name); }
        public abstract void work();
    }

    private static final class Developer extends Worker {
        private Developer(String name) { super(name); }
        @Override public void work() { System.out.println("Write software"); }
    }
}
