package com.example.designpattern.structural;

// Facade: offer one simple method that coordinates several subsystem objects.
public class Facade01HomeTheaterDemo {
    static class Projector { void on() { System.out.println("Projector on"); } }
    static class SoundSystem { void play() { System.out.println("Sound on"); } }
    static class Player { void playMovie(String name) { System.out.println("Playing " + name); } }

    static class HomeTheaterFacade {
        private final Projector projector = new Projector();
        private final SoundSystem sound = new SoundSystem();
        private final Player player = new Player();
        void watch(String movie) {
            projector.on(); sound.play(); player.playMovie(movie);
        }
    }

    public static void main(String[] args) {
        new HomeTheaterFacade().watch("Finding Nemo");
    }
}
