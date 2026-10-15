package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//A Simple Java program to demonstrate
//Overriding and Access-Modifiers

/**
 * Easy: Demonstrates Method Overriding3 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Parent3 {
	// private methods are not overridden
	@SuppressWarnings("unused")
	final void m1() {
		System.out.println("From Parent3 m1()");
	}

	protected void m2() {
		System.out.println("From Parent3 m2()");
	}
}

class Child3 extends Parent3 {
	// new m1() method
	// unique to Child3 class
	@SuppressWarnings("unused")
//	private void m1() {
//		System.out.println("From Child3 m1()");   // Final methods can not be overridden
//	}

	// overriding method
	// with more accessibility
	@Override
	public void m2() {
		System.out.println("From Child3 m2()");
	}
}

//Driver class
class MethodOverriding3 {
	public static void main(String[] args) {
		Parent3 obj1 = new Parent3();
		obj1.m2();
		Parent3 obj2 = new Child3();
		obj2.m2();
	}
}