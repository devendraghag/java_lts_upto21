package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Method Overriding4 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Parent4 {
	void m1() {
		System.out.println("From Parent4 m1()");
	}
}

class Child4 extends Parent4 {
	void m1() {
		System.out.println("From Child4 m2()");
	}
}

//Driver class
class MethodOverriding4 {
	public static void main(String[] args) {
		Parent4 obj1 = new Parent4();
		obj1.m1();
		Parent4 obj2 = new Child4();
		obj2.m1();
	}
}