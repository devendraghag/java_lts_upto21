package com.example.example.recordpatterns;

/** Level 10: a nested type pattern does not match when that record component is null. */
public class RecordPattern10NullNestedComponent {
    record Address(String city) { }
    record Person(String name, Address address) { }

    static String describe(Object value) {
        if (value instanceof Person(String name, Address(String city))) {
            return name + " lives in " + city;
        }

        // This outer pattern still matches a Person whose address component is null.
        if (value instanceof Person(var name, var address)) {
            return address == null ? name + " has no address" : name + " has an address";
        }

        return "Not a person";
    }

    public static void main(String[] args) {
        System.out.println(describe(new Person("Mina", new Address("Pune"))));
        System.out.println(describe(new Person("Asha", null)));
        System.out.println(describe("visitor"));
    }
}
