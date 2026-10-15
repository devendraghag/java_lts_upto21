package com.example.aggregation;

import java.util.List;

/** Demonstrates one team aggregating independently-created players. */
public class OneToManyAggregationDemo {
    public static void main(String[] args) {
        Player ada = new Player("Ada");
        Player ben = new Player("Ben");
        Team team = new Team("Falcons", List.of(ada, ben));

        team.printRoster();
        System.out.println("Player can be referenced without the team: " + ada.name());
    }

    private record Player(String name) { }

    private static final class Team {
        private final String name;
        private final List<Player> players;

        private Team(String name, List<Player> players) {
            this.name = name;
            this.players = List.copyOf(players);
        }

        private void printRoster() {
            System.out.println(name + " roster:");
            players.forEach(player -> System.out.println("  " + player.name()));
        }
    }
}
