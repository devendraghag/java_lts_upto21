package com.example.example.methodoverloading;

/** Rule 14: a child class can overload an inherited method with a new parameter list. */
class Rule14Parent {
    String identify(int id) {
        return "id=" + id;
    }
}

public class Rule14OverloadParentAndChildMethods extends Rule14Parent {
    String identify(String name) {
        return "name=" + name;
    }

    public static void main(String[] args) {
        Rule14OverloadParentAndChildMethods example = new Rule14OverloadParentAndChildMethods();
        System.out.println(example.identify(14));
        System.out.println(example.identify("child"));
    }
}
