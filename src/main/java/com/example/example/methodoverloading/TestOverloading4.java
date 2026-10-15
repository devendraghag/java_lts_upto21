package com.example.methodoverloading;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Test Overloading4 in the Method Overloading topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class TestOverloading4 {
	public static void main(String[] args) {
		System.out.println("main with String[]");
	}

	public static void main(String args) {
		System.out.println("main with String");
	}

	public static void main() {
		System.out.println("main without args");
	}
}