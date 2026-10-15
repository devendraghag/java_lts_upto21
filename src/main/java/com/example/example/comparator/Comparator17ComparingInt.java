package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator17ComparingInt {
    record Player(String name, int score) {}

    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Ira", 80),
                new Player("Asha", 95),
                new Player("Bo", 80));

        Comparator<Player> byScore = Comparator.comparingInt(Player::score);
        System.out.println(players.stream().sorted(byScore).toList());
    }
}
