package com.example.methodoverloading;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


/**
 * Easy: Demonstrates Test Overloading5 in the Method Overloading topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Adder33 {
	static int add(int a, int b) {
		return a + b;
	}

	public double add(double a, double b) {
		return a + b;
	}
}

class TestOverloading5 {
	public static void main(String[] args) {
		System.out.println(Adder33.add(11, 11));
	}
}

//overloading depends on method name, no of variables and type of variables not with the access specifiers