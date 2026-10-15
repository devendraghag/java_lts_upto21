package com.example.composition;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates composition and related object relationships in Java.
 * Uses standard Java features available through JDK 21; no preview or
 * incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/composition/CompositionExamples.java
 *   java -cp out com.example.composition.CompositionExamples
 *
 * Java has no special composition keyword: these relationships are modeled
 * with fields, constructors, and method delegation.
 */
public class CompositionExamples {
    public static void main(String[] args) {
        strongComposition();
        aggregation();
        constructorInjectionAndDelegation();
        immutableComposition();
        compositionInsteadOfInheritance();
    }

    private static void strongComposition() {
        System.out.println("== Strong composition / ownership ==");

        Document document = new Document("Java Notes");
        document.addSection("Introduction", "Java is object oriented.");
        document.addSection("Composition", "Objects can be built from other objects.");
        document.print();

        // Document creates and owns its Section objects. Its public API does not
        // expose mutable Section references, which keeps ownership encapsulated.
    }

    private static void aggregation() {
        System.out.println("\n== Aggregation / shared independent objects ==");

        Employee ada = new Employee("E-1", "Ada");
        Employee linus = new Employee("E-2", "Linus");
        Team platform = new Team("Platform", List.of(ada, linus));
        Team mentoring = new Team("Mentoring", List.of(ada));

        platform.printMembers();
        mentoring.printMembers();
        System.out.println("Ada remains usable independently: " + ada.name());

        // Teams retain references to Employee objects created outside the teams.
        // An Employee can be shared and can outlive either Team: this models aggregation.
    }

    private static void constructorInjectionAndDelegation() {
        System.out.println("\n== Constructor injection and delegation ==");

        MessageSender sender = new ConsoleMessageSender();
        NotificationService service = new NotificationService(sender);
        service.notifyUser("Build finished");

        // NotificationService has a MessageSender and delegates sending to it.
        // Supplying the interface implementation in the constructor makes it replaceable.
    }

    private static void immutableComposition() {
        System.out.println("\n== Immutable object composition ==");

        Address address = new Address("12 River Road", "Pune");
        Customer customer = new Customer("Mira", address);
        System.out.println(customer.name() + " lives at " + customer.address().format());

        // Records are final immutable data carriers (records became final in JDK 16).
        // A record can contain another record as one of its components.
    }

    private static void compositionInsteadOfInheritance() {
        System.out.println("\n== Composition instead of inheritance ==");

        Greeter greeting = new Greeter(new GreetingStyle("Good morning"));
        greeting.greet("Sam");

        // Greeter has a GreetingStyle and delegates part of its behavior to it.
        // This models a has-a relationship; inheritance would model an is-a relationship.
    }

    // One-to-many composition: a Document owns a list of its Sections.
    private static final class Document {
        private final String title;
        private final List<Section> sections = new ArrayList<>();

        private Document(String title) {
            this.title = title;
        }

        void addSection(String heading, String body) {
            sections.add(new Section(heading, body)); // child created by its owner
        }

        void print() {
            System.out.println("Document: " + title);
            for (Section section : sections) {
                section.print();
            }
        }
    }

    // Private nested implementation prevents callers from managing Sections directly.
    private static final class Section {
        private final String heading;
        private final String body;

        private Section(String heading, String body) {
            this.heading = heading;
            this.body = body;
        }

        private void print() {
            System.out.println("  " + heading + ": " + body);
        }
    }

    // Aggregation: the team receives references to Employee objects it does not own.
    private record Employee(String id, String name) { }

    private static final class Team {
        private final String name;
        private final List<Employee> members;

        private Team(String name, List<Employee> members) {
            this.name = name;
            this.members = new ArrayList<>(members); // copies the list, not its employees
        }

        void printMembers() {
            System.out.println(name + " members: "
                    + members.stream().map(Employee::name).toList());
        }
    }

    private interface MessageSender {
        void send(String message);
    }

    private static final class ConsoleMessageSender implements MessageSender {
        @Override
        public void send(String message) {
            System.out.println("Sending: " + message);
        }
    }

    private static final class NotificationService {
        private final MessageSender sender;

        private NotificationService(MessageSender sender) {
            this.sender = sender;
        }

        void notifyUser(String message) {
            sender.send(message); // delegation to a composed dependency
        }
    }

    // Immutable one-to-one composition using records.
    private record Address(String street, String city) {
        String format() {
            return street + ", " + city;
        }
    }

    private record Customer(String name, Address address) { }

    private static final class GreetingStyle {
        private final String opening;

        private GreetingStyle(String opening) {
            this.opening = opening;
        }

        String format(String name) {
            return opening + ", " + name + "!";
        }
    }

    private static final class Greeter {
        private final GreetingStyle style;

        private Greeter(GreetingStyle style) {
            this.style = style;
        }

        void greet(String name) {
            System.out.println(style.format(name));
        }
    }
}
