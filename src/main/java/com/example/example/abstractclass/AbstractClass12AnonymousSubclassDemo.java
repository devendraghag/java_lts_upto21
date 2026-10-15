package com.example.abstractclass;

/** Creates an anonymous subclass to implement an abstract class inline. */
public class AbstractClass12AnonymousSubclassDemo {
    public static void main(String[] args) {
        Greeting greeting = new Greeting("Hello") {
            @Override
            public void sayTo(String name) {
                System.out.println(message + ", " + name + "!");
            }
        };

        greeting.sayTo("Java learner");
    }

    private abstract static class Greeting {
        protected final String message;

        protected Greeting(String message) {
            this.message = message;
        }

        public abstract void sayTo(String name);
    }
}
