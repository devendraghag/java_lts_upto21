package com.example.switchstatement;

/** Demonstrates switching on enum constants. */
public class EnumSwitchStatementDemo {
    private enum Season {
        SPRING, SUMMER, AUTUMN, WINTER
    }

    public static void main(String[] args) {
        Season season = Season.SUMMER;

        switch (season) {
            case SPRING:
                System.out.println("Flowers bloom");
                break;
            case SUMMER:
                System.out.println("Days are warm");
                break;
            case AUTUMN:
                System.out.println("Leaves change color");
                break;
            case WINTER:
                System.out.println("Days are cold");
                break;
            default:
                System.out.println("Unknown season");
                break;
        }
    }
}
