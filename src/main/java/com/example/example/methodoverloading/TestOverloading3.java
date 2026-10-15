package com.example.methodoverloading;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.


//Why Method Overloading is not possible by changing the return type of method only?
/**
 * Easy: Demonstrates Test Overloading3 in the Method Overloading topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
class Adder3 {
	static int add(int a, int b) {
		return a + b;
	}

//	static double add(int a, int b) {
//		return a + b;
//	}
}

class TestOverloading3 {
	public static void main(String[] args) {
		System.out.println(Adder3.add(11, 11));// ambiguity
	}
}