package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Method Overriding6 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Parent7 {
//	void m1() {
//		System.out.println("From Parent7 m1()");
//	}
}

class Child7 extends Parent7 {
	static void m1() {
		System.out.println("From Child7 m2()");  // static you can not put here or put static parent class
	}
}

//Driver class
class MethodOverriding6 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Parent7 obj1 = new Parent7();
		Parent7 obj2 = new Child7();
	}
}