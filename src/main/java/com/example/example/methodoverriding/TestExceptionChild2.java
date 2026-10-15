package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or
// no exception but cannot declare parent exception.
/**
 * Easy: Demonstrates Test Exception Child2 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class Parent13 {
	void msg() throws ArithmeticException {
		System.out.println("Parent13");
	}
}

class TestExceptionChild2 extends Parent13 {
//	void msg() throws Exception {
//		System.out.println("child");
//	}

	public static void main(String args[]) {
		Parent13 p = new TestExceptionChild2();
		try {
			p.msg();
		} catch (Exception e) {
		}
	}
}