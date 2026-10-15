package com.example.stringbuilder;

/** Contrasts mutable StringBuilder and synchronized StringBuffer use cases. */
public class StringBuilderVsStringBufferDemo {
    public static void main(String[] args) {
        StringBuilder singleThreaded = new StringBuilder("Builder");
        singleThreaded.append(" is mutable");

        StringBuffer synchronizedBuffer = new StringBuffer("Buffer");
        synchronizedBuffer.append(" synchronizes its methods");

        System.out.println(singleThreaded);
        System.out.println(synchronizedBuffer);
    }
}
