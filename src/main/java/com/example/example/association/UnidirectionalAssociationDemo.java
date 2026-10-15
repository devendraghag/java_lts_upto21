package com.example.association;

import java.util.List;

/** Demonstrates a unidirectional association from a playlist to its songs. */
public class UnidirectionalAssociationDemo {
    private record Song(String title) {
    }

    private record Playlist(String name, List<Song> songs) {
        private Playlist {
            songs = List.copyOf(songs);
        }
    }

    public static void main(String[] args) {
        Song first = new Song("Morning Light");
        Song second = new Song("Long Road");
        Playlist playlist = new Playlist("Road Trip", List.of(first, second));

        System.out.println(playlist.name() + " contains:");
        for (Song song : playlist.songs()) {
            System.out.println("- " + song.title());
        }
        // Song has no reference back to its playlist.
    }
}
