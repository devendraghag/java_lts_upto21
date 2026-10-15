package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//A Simple Java program to demonstrate
//method overriding in java

//Base Class
/**
 * Easy: Demonstrates Method Overriding in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Parent {
    void show() {
        System.out.println("Parent's show()");
    }
}

//Inherited class
class Child extends Parent {
    // This method overrides show() of Parent
    @Override
    void show() {
        System.out.println("Child's show()");
    }
}

//Driver class
class MethodOverriding {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // If a Parent type reference refers
        // to a Parent object, then Parent's
        // show is called
        Parent obj1 = new Parent();
        //	obj1.show();

        // If a Parent type reference refers
        // to a Child object Child's show()
        // is called. This is called RUN TIME
        // POLYMORPHISM.
        Parent obj2 = new Child();
        obj2.show();

        Child obje3 = new Child();
        obje3.show();

        Child obje4 = (Child) new Parent(); // you have type casted but it will not work
        //	obje4.show();

//		Exception in thread "main" java.lang.ClassCastException: MethodOverriding.Parent cannot be cast to MethodOverriding.Child
//		at MethodOverriding.MethodOverriding.main(MethodOverriding.java:41)

    }
}