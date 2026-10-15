package com.example.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

// Listener-style Observer: listeners can register and unregister with the event source.
public class Observer02EventListenerDemo {
    interface ClickListener { void clicked(String buttonName); }
    static class Button {
        private final List<ClickListener> listeners = new ArrayList<ClickListener>();
        void addListener(ClickListener listener) { listeners.add(listener); }
        void removeListener(ClickListener listener) { listeners.remove(listener); }
        void click(String name) {
            for (ClickListener listener : new ArrayList<ClickListener>(listeners)) listener.clicked(name);
        }
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.addListener(name -> System.out.println(name + " click logged"));
        button.addListener(name -> System.out.println(name + " action handled"));
        button.click("Save");
    }
}
