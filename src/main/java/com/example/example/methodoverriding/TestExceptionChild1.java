package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//If the superclass method does not declare an exception, subclass overridden method cannot declare the 
//checked exception but can declare unchecked exception
/**
 * Easy: Demonstrates Test Exception Child1 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class Parent12 {
	void msg() {
		System.out.println("Parent12");
	}
}

class TestExceptionChild1 extends Parent12 {
	void msg() throws ArithmeticException {
		System.out.println("child");
	}

	public static void main(String args[]) {
		Parent12 p = new TestExceptionChild1();
		p.msg();
	}
}