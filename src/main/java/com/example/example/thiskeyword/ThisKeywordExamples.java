package com.example.thiskeyword;

/**
 * Demonstrates common uses of the Java this keyword through JDK 21.
 * No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/thiskeyword/ThisKeywordExamples.java
 *   java -cp out com.example.thiskeyword.ThisKeywordExamples
 */
public class ThisKeywordExamples {
    private final String ownerName = "ThisKeywordExamples instance";

    public static void main(String[] args) {
        accessCurrentObjectMembers();
        chainConstructors();
        passAndReturnThis();
        qualifyOuterAndInnerThis();
        new ThisKeywordExamples().thisInLambdaAndAnonymousClass();
    }

    private static void accessCurrentObjectMembers() {
        System.out.println("== this refers to the current object ==");

        Person person = new Person("Asha", 25);
        person.printDetails();
    }

    private static void chainConstructors() {
        System.out.println("\n== Constructor chaining with this(...) ==");

        Book defaultBook = new Book("Java Basics");
        Book specifiedBook = new Book("Java in Practice", 2026);
        System.out.println(defaultBook);
        System.out.println(specifiedBook);
    }

    private static void passAndReturnThis() {
        System.out.println("\n== Pass this and return this ==");

        Message message = new Message("Hello from the current object");
        MessageReceiver receiver = new MessageReceiver();
        message.deliverTo(receiver); // passes this as an argument

        FluentCounter counter = new FluentCounter();
        counter.increment().increment().add(3).print(); // methods return this for chaining
    }

    private static void qualifyOuterAndInnerThis() {
        System.out.println("\n== OuterClass.this and inner this ==");

        Outer outer = new Outer("outer value");
        Outer.Inner inner = outer.new Inner("inner value");
        inner.printValues();
    }

    private void thisInLambdaAndAnonymousClass() {
        System.out.println("\n== this in a lambda and anonymous class ==");

        Runnable lambda = () -> System.out.println(
                "Lambda this is the enclosing object: " + (this.ownerName));
        Runnable anonymous = new Runnable() {
            private final String ownerName = "anonymous object";

            @Override
            public void run() {
                System.out.println("Anonymous-class this is: " + this.ownerName);
                System.out.println("Outer object from anonymous class: "
                        + ThisKeywordExamples.this.ownerName);
            }
        };

        lambda.run();
        anonymous.run();
    }

    private static final class Person {
        private String name;
        private int age;

        private Person(String name, int age) {
            this.name = name; // disambiguates fields from constructor parameters
            this.age = age;
        }

        private void printDetails() {
            this.printName(); // explicitly calls an instance method on this object
            System.out.println("age=" + this.age);
        }

        private void printName() {
            System.out.println("name=" + this.name);
        }
    }

    private static final class Book {
        private final String title;
        private final int year;

        private Book(String title) {
            this(title, 2021); // delegates to the other constructor; must be first statement
        }

        private Book(String title, int year) {
            this.title = title;
            this.year = year;
        }

        @Override
        public String toString() {
            return title + " (" + year + ")";
        }
    }

    private static final class Message {
        private final String text;

        private Message(String text) {
            this.text = text;
        }

        private void deliverTo(MessageReceiver receiver) {
            receiver.receive(this); // passes the current Message object
        }
    }

    private static final class MessageReceiver {
        private void receive(Message message) {
            System.out.println("Received: " + message.text);
        }
    }

    private static final class FluentCounter {
        private int value;

        private FluentCounter increment() {
            value++;
            return this; // returns this same object
        }

        private FluentCounter add(int amount) {
            value += amount;
            return this;
        }

        private void print() {
            System.out.println("chained counter value=" + value);
        }
    }

    private static final class Outer {
        private final String value;

        private Outer(String value) {
            this.value = value;
        }

        private final class Inner {
            private final String value;

            private Inner(String value) {
                this.value = value;
            }

            private void printValues() {
                System.out.println("Inner.this.value=" + this.value);
                System.out.println("Outer.this.value=" + Outer.this.value);
            }
        }
    }

    /*
     * this is an instance reference and cannot be used in a static context:
     *
     * static void invalid() {
     *     System.out.println(this); // compile-time error
     * }
     *
     * A constructor may use this(...) to delegate to another constructor, or
     * super(...) to invoke its superclass constructor; it cannot use both.
     * A this(...) call must be the constructor's first statement.
     */
}
