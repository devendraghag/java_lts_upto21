package com.example.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

// Push Observer: a subject pushes each new event to every registered listener.
public class Observer01PushNotificationDemo {
    interface Subscriber { void onVideoPublished(String title); }
    static class Viewer implements Subscriber {
        private final String name;
        Viewer(String name) { this.name = name; }
        public void onVideoPublished(String title) { System.out.println(name + " saw: " + title); }
    }
    static class Channel {
        private final List<Subscriber> subscribers = new ArrayList<Subscriber>();
        void subscribe(Subscriber subscriber) { subscribers.add(subscriber); }
        void publish(String title) {
            for (Subscriber subscriber : subscribers) subscriber.onVideoPublished(title);
        }
    }

    public static void main(String[] args) {
        Channel channel = new Channel();
        channel.subscribe(new Viewer("Asha"));
        channel.subscribe(new Viewer("Ravi"));
        channel.publish("Observer Pattern Explained");
    }
}
