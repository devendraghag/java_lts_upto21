package com.example.example.wrapperclasses;

/** Shows the eight primitive wrapper classes and the extra Void wrapper. */
public class WrapperClass01WrapperTypes {
    public static void main(String[] args) {
        Boolean booleanValue = Boolean.TRUE;
        Byte byteValue = Byte.valueOf((byte) 10);
        Short shortValue = Short.valueOf((short) 20);
        Character characterValue = Character.valueOf('J');
        Integer integerValue = Integer.valueOf(30);
        Long longValue = Long.valueOf(40L);
        Float floatValue = Float.valueOf(1.5F);
        Double doubleValue = Double.valueOf(2.5);

        System.out.println(booleanValue + ", " + byteValue + ", " + shortValue + ", " + characterValue);
        System.out.println(integerValue + ", " + longValue + ", " + floatValue + ", " + doubleValue);
        System.out.println("Void.TYPE is the class token for void: " + (Void.TYPE == void.class));
    }
}
