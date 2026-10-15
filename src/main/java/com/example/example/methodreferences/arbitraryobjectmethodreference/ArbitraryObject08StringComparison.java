package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.Comparator;

/** Medium: String::compareToIgnoreCase matches Comparator<String>'s two inputs. */
public class ArbitraryObject08StringComparison {
    public static void main(String[] args) {
        // compare(left, right) is implemented as left.compareToIgnoreCase(right).
        Comparator<String> lambda = (left, right) -> left.compareToIgnoreCase(right);
        Comparator<String> reference = String::compareToIgnoreCase;

        System.out.println(lambda.compare("apple", "Banana"));
        System.out.println(reference.compare("JAVA", "java"));
    }
}
