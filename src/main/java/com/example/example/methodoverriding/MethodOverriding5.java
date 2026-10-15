package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Method Overriding5 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Parent6 {
	static void m1() {
		System.out.println("From Parent6 m1()");
	}
}

class Child6 extends Parent6 {
	static void m1() {
		System.out.println("From Child6 m2()");  // static you have to put
	}
}

//Driver class
class MethodOverriding5 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Parent6 obj1 = new Parent6();
		obj1.m1();
		Parent6 obj2 = new Child6();
		obj2.m1();
	}
}