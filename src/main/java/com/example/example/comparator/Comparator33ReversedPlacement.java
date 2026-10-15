package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator33ReversedPlacement {
    record Player(String name, int score) {}

    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Zoe", 90),
                new Player("Asha", 90),
                new Player("Bo", 100));

        // Reverse only the score comparator, then leave the name tie-break ascending.
        Comparator<Player> scoreDescendingNameAscending = Comparator
                .comparingInt(Player::score).reversed()
                .thenComparing(Player::name);

        // Reversing after the full chain reverses both score and name directions.
        Comparator<Player> bothDescending = Comparator
                .comparingInt(Player::score)
                .thenComparing(Player::name)
                .reversed();

        System.out.println(players.stream().sorted(scoreDescendingNameAscending).toList());
        System.out.println(players.stream().sorted(bothDescending).toList());
    }
}
