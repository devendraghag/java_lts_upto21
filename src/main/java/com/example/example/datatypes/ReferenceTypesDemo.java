package com.example.datatypes;

import java.util.List;

/** Demonstrates classes, interfaces, arrays, enums, records, and parameterized types. */
public class ReferenceTypesDemo {
    public static void main(String[] args) {
        Person person = new Person("Asha");        // Class type.
        Named named = person;                       // Interface type.
        String[] names = {person.name(), "Ravi"};  // Array type.
        Level level = Level.ADVANCED;               // Enum type.
        Point point = new Point(4, 7);              // Record type.
        List<String> topics = List.of("Java", "JDK"); // Parameterized reference type.
        Person missing = null;                      // A reference may be null.

        System.out.println("Class value: " + person.name());
        System.out.println("Interface value: " + named.displayName());
        System.out.println("Array value: " + names[1]);
        System.out.println("Enum value: " + level);
        System.out.println("Record value: " + point);
        System.out.println("Parameterized type value: " + topics);
        System.out.println("Null reference: " + missing);

        Object value = person;
        if (value instanceof Person matchingPerson) {
            System.out.println("Pattern-matched class reference: " + matchingPerson.name());
        }
    }

    private interface Named {
        String displayName();
    }

    private record Person(String name) implements Named {
        @Override
        public String displayName() {
            return "Person: " + name;
        }
    }

    private record Point(int x, int y) { }
    private enum Level { BEGINNER, INTERMEDIATE, ADVANCED }
}
