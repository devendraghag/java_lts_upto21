package com.example.example.helloworldways;

import java.util.Locale;

/** Uses String.format with an explicit locale for predictable formatting. */
public class HelloWorld09LocaleAwareFormat {
    public static void main(String[] args) {
        System.out.println(String.format(Locale.ROOT, "%s, %s!", "Hello", "World"));
    }
}
