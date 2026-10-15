package com.example.statickeyword;

/** Demonstrates a static nested class and how to instantiate it. */
public class StaticNestedClassDemo {
    private static final String OUTER_CONSTANT = "outer class constant";
    private final String instanceValue = "outer instance value";

    public static void main(String[] args) {
        Catalog.Entry entry = new Catalog.Entry("JDK 21");
        entry.print();

        StaticNestedClassDemo outer = new StaticNestedClassDemo();
        System.out.println(outer.instanceValue);
    }

    private static final class Catalog {
        private static final class Entry {
            private final String name;

            private Entry(String name) {
                this.name = name;
            }

            private void print() {
                System.out.println(name + " uses " + OUTER_CONSTANT);
            }
        }
    }
}
