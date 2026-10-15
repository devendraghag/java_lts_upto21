package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//Example in case subclass overridden method declares same exception
/**
 * Easy: Demonstrates Test Exception Child3 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class Parent14 {
	void msg() throws Exception {
		System.out.println("Parent14");
	}
}

class TestExceptionChild3 extends Parent14 {
	void msg() throws Exception {
		System.out.println("child");
	}

	public static void main(String args[]) {
		Parent14 p = new TestExceptionChild3();
		try {
			p.msg();
		} catch (Exception e) {
		}
	}
}