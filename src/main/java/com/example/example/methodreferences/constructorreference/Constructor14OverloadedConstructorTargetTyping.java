package com.example.methodreferences.constructorreference;

import java.util.function.Function;
import java.util.function.IntFunction;

/** Hard: the target functional-interface type selects which overloaded constructor is used. */
public class Constructor14OverloadedConstructorTargetTyping {
    static class Label {
        private final String text;

        Label(String text) {
            this.text = "text=" + text;
        }

        Label(int number) {
            this.text = "number=" + number;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public static void main(String[] args) {
        // Function chooses Label(String); IntFunction chooses Label(int).
        Function<String, Label> fromText = Label::new;
        IntFunction<Label> fromNumber = Label::new;

        System.out.println(fromText.apply("hello"));
        System.out.println(fromNumber.apply(21));
    }
}
