package com.example.abstractclass;

/** Generic abstract classes provide reusable behavior over a chosen type. */
public class AbstractClass14GenericBaseDemo {
    public static void main(String[] args) {
        Box<String> box = new StringBox("Java");
        System.out.println(box.get());
    }

    private abstract static class Box<T> {
        private final T value;
        protected Box(T value) { this.value = value; }
        public T get() { return value; }
        public abstract String describe();
    }

    private static final class StringBox extends Box<String> {
        private StringBox(String value) { super(value); }
        @Override public String describe() { return "Text: " + get(); }
    }
}
