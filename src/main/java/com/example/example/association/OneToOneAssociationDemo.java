package com.example.association;

/** Demonstrates a bidirectional one-to-one association. */
public class OneToOneAssociationDemo {
    private static final class Person {
        private final String name;
        private Passport passport;

        private Person(String name) {
            this.name = name;
        }

        private void assignPassport(Passport passport) {
            this.passport = passport;
            passport.owner = this;
        }
    }

    private static final class Passport {
        private final String number;
        private Person owner;

        private Passport(String number) {
            this.number = number;
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Asha");
        Passport passport = new Passport("P-1001");
        person.assignPassport(passport);

        System.out.println(person.name + " has passport " + person.passport.number);
        System.out.println("Passport owner: " + passport.owner.name);
    }
}
