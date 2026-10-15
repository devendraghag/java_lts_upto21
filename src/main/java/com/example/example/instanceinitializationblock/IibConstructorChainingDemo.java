package com.example.instanceinitializationblock;

/** Shows that an IIB runs once when a constructor chain uses this(...). */
public class IibConstructorChainingDemo {
    public static void main(String[] args) {
        System.out.println("Creating with the no-argument constructor:");
        new Member();

        System.out.println("Creating with the named constructor:");
        new Member("Asha");
    }

    private static final class Member {
        private final String name;

        {
            System.out.println("IIB: common per-object initialization");
        }

        private Member() {
            this("Guest");
            System.out.println("No-argument constructor body");
        }

        private Member(String name) {
            this.name = name;
            System.out.println("Named constructor body: " + this.name);
        }
    }
}
