package com.example.methodoverriding;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//Example in case subclass overridden method declares no exception
/**
 * Easy: Demonstrates Test Exception Child5 in the Method Overriding topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class Parent16 {
	void msg() throws Exception {
		System.out.println("Parent16");
	}
}

class TestExceptionChild5 extends Parent16 {
	void msg() {
		System.out.println("child");
	}

	public static void main(String args[]) {
		Parent16 p = new TestExceptionChild5();
		try {
			p.msg();
		} catch (Exception e) {
		}
	}
}