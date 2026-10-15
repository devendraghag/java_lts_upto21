package com.example.instanceinitializationblock;

/** Shows superclass and subclass initialization order. */
public class InheritanceIibOrderDemo {
    public static void main(String[] args) {
        System.out.println("Creating a Child:");
        new Child();
    }

    private static class Parent {
        private String parentValue = log("Parent field initializer");

        {
            log("Parent IIB");
        }

        protected Parent() {
            log("Parent constructor body");
        }

        protected String getParentValue() {
            return parentValue;
        }

        protected String log(String message) {
            System.out.println(message);
            return message;
        }
    }

    private static final class Child extends Parent {
        private String childValue = log("Child field initializer");

        {
            log("Child IIB");
        }

        private Child() {
            log("Child constructor body");
            System.out.println("Values are initialized: "
                    + getParentValue() + " / " + childValue);
        }
    }
}
