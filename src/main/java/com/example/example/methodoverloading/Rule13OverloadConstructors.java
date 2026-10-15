package com.example.example.methodoverloading;

/** Rule 13: constructors can be overloaded by parameter list. */
public class Rule13OverloadConstructors {
    private final String name;
    private final int age;

    Rule13OverloadConstructors(String name) {
        this(name, 0);
    }

    Rule13OverloadConstructors(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Rule13OverloadConstructors first = new Rule13OverloadConstructors("Mina");
        Rule13OverloadConstructors second = new Rule13OverloadConstructors("Ravi", 30);
        System.out.println(first.name + ", " + first.age);
        System.out.println(second.name + ", " + second.age);
    }
}
