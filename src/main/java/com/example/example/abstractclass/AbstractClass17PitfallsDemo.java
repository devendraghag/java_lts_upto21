package com.example.abstractclass;

/** Common declaration rules; invalid forms are documented in comments below. */
public class AbstractClass17PitfallsDemo {
    public static void main(String[] args) {
        Task task = new CleanupTask();
        task.execute();
        System.out.println("See comments for declarations that do not compile.");
    }

    private abstract static class Task {
        public final void execute() { perform(); }
        protected abstract void perform();
    }

    private static final class CleanupTask extends Task {
        @Override protected void perform() { System.out.println("Cleanup complete"); }
    }

    /*
     * Invalid examples (uncomment individually to see compiler errors):
     * abstract private void run();  // private methods cannot be overridden
     * abstract static void load();  // abstract methods require instance dispatch
     * final abstract class Base {} // final forbids subclasses
     * abstract final void stop();  // final forbids overriding
     * new Task();                  // abstract classes cannot be instantiated
     * An abstract class may have a constructor, but constructors are never abstract.
     */
}
