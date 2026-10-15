package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//A Simple Java program to demonstrate
//Overriding and Access-Modifiers

/**
 * Easy: Demonstrates Method Overriding2 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Parent2 {
	// private methods are not overridden
	@SuppressWarnings("unused")
	private void m1() {
		System.out.println("From Parent2 m1()");
	}

	protected void m2() {
		System.out.println("From Parent2 m2()");
	}
}

class Child2 extends Parent2 {
	// new m1() method
	// unique to Child2 class
	@SuppressWarnings("unused")
	private void m1() {
		System.out.println("From Child2 m1()");
	}

	// overriding method
	// with more accessibility
	@Override
	public void m2() {
		System.out.println("From Child2 m2()");
	}
}

//Driver class
class MethodOverriding2 {
	public static void main(String[] args) {
		Parent2 obj1 = new Parent2();
		obj1.m2();
		Parent2 obj2 = new Child2();
		obj2.m2();
	}
}