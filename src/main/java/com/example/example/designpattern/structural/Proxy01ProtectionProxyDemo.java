package com.example.designpattern.structural;

// Protection Proxy: check permission before forwarding the call to the real object.
public class Proxy01ProtectionProxyDemo {
    interface Document { void open(); }
    static class RealDocument implements Document {
        public void open() { System.out.println("Sensitive document opened"); }
    }
    static class DocumentProxy implements Document {
        private final Document real = new RealDocument();
        private final boolean allowed;
        DocumentProxy(boolean allowed) { this.allowed = allowed; }
        public void open() {
            if (allowed) real.open();
            else System.out.println("Access denied");
        }
    }

    public static void main(String[] args) {
        new DocumentProxy(false).open();
        new DocumentProxy(true).open();
    }
}
