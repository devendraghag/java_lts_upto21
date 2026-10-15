package com.example.superkeyword;

/**
 * Demonstrates common uses of Java's super keyword through JDK 21.
 * No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/superkeyword/SuperKeywordExamples.java
 *   java -cp out com.example.superkeyword.SuperKeywordExamples
 */
public class SuperKeywordExamples {
    public static void main(String[] args) {
        accessParentField();
        callParentMethod();
        invokeParentConstructors();
        chooseInterfaceDefaultMethods();
    }

    private static void accessParentField() {
        System.out.println("== Access a hidden superclass field ==");

        Child child = new Child();
        child.printFields();
    }

    private static void callParentMethod() {
        System.out.println("\n== Call an overridden superclass method ==");

        new Child().show();
    }

    private static void invokeParentConstructors() {
        System.out.println("\n== Invoke superclass constructors ==");

        new NamedChild("explicit super call");
        new DefaultChild(); // compiler inserts super() as the first constructor action
    }

    private static void chooseInterfaceDefaultMethods() {
        System.out.println("\n== Select interface default implementations ==");

        new CombinedGreeting().greet();
    }

    private static class Parent {
        protected String label = "parent field";

        protected Parent() {
            System.out.println("Parent no-argument constructor");
        }

        protected Parent(String label) {
            this.label = label;
            System.out.println("Parent constructor: " + label);
        }

        void show() {
            System.out.println("Parent.show()");
        }
    }

    private static class Child extends Parent {
        private String label = "child field";

        private Child() {
            super();
        }

        void printFields() {
            System.out.println("this.label: " + this.label);
            System.out.println("super.label: " + super.label);
        }

        @Override
        void show() {
            System.out.println("Child.show() starts");
            super.show(); // explicitly invoke the direct superclass implementation
            System.out.println("Child.show() ends");
        }
    }

    private static class NamedParent {
        private NamedParent(String name) {
            System.out.println("NamedParent constructor: " + name);
        }
    }

    private static final class NamedChild extends NamedParent {
        private NamedChild(String name) {
            super(name); // must be the first statement in this constructor
            System.out.println("NamedChild constructor body");
        }
    }

    private static class DefaultParent {
        private DefaultParent() {
            System.out.println("DefaultParent constructor");
        }
    }

    private static final class DefaultChild extends DefaultParent {
        private DefaultChild() {
            // No explicit constructor invocation: Java inserts super().
            System.out.println("DefaultChild constructor body");
        }
    }

    private interface FriendlyGreeting {
        default void greet() {
            System.out.println("Hello!");
        }
    }

    private interface CasualGreeting {
        default void greet() {
            System.out.println("Hi!");
        }
    }

    private static final class CombinedGreeting implements FriendlyGreeting, CasualGreeting {
        @Override
        public void greet() {
            FriendlyGreeting.super.greet(); // qualified super selects one interface default
            CasualGreeting.super.greet();
            System.out.println("CombinedGreeting adds its own behavior");
        }
    }

    /*
     * Notes:
     * - super refers to the direct superclass; Java has no super.super syntax.
     * - A private superclass member is not accessible with super.
     * - A constructor uses super(...) or this(...) as its first statement, not both.
     * - super is an instance reference and cannot be used from a static method.
     */
}
