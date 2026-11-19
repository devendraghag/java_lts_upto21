package com.example.composition;

import java.util.ArrayList;
import java.util.List;

/** A Playlist owns its internally-created Track objects and controls mutation. */
public class Composition02OwnedCollection {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Focus");
        playlist.addTrack("Morning Light");
        playlist.addTrack("Quiet Road");
        playlist.printTracks();
    }
    private static final class Playlist {
        private final String name;
        private final List<Track> tracks = new ArrayList<>();
        private Playlist(String name) { this.name = name; }
        private void addTrack(String title) { tracks.add(new Track(title)); }
        private void printTracks() {
            System.out.println(name + ": " + tracks.stream().map(track -> track.title).toList());
        }
    }
    private static final class Track {
        private final String title;
        private Track(String title) { this.title = title; }
    }
}
