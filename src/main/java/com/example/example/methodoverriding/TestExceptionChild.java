package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


// If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception.
/**
 * Easy: Demonstrates Test Exception Child in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class Parent11 {
	void msg() {
		System.out.println("Parent11");
	}
}

public class TestExceptionChild extends Parent11 {
//	void msg() throws IOException {
//		System.out.println("TestExceptionChild");
//	}

	public static void main(String args[]) {
		Parent11 p = new TestExceptionChild();
		p.msg();
	}
}