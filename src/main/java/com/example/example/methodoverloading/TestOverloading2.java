package com.example.methodoverloading;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//Method Overloading: changing data type of arguments
/**
 * Easy: Demonstrates Test Overloading2 in the Method Overloading topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Adder2 {
	static int add(int a, int b) {
		return a + b;
	}

	static double add(double a, double b) {
		return a + b;
	}
}

class TestOverloading2 {
	public static void main(String[] args) {
		System.out.println(Adder2.add(11, 11)); // if i keep single then it will go to int bcz its specific
	}
}