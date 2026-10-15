package com.example.designpattern.structural;

// Decorator pipeline: each wrapper adds one processing step around the message component.
public class Decorator02MessagePipelineDemo {
    interface Message { String text(); }
    static class PlainMessage implements Message {
        private final String value;
        PlainMessage(String value) { this.value = value; }
        public String text() { return value; }
    }
    abstract static class MessageWrapper implements Message {
        protected final Message inner;
        MessageWrapper(Message inner) { this.inner = inner; }
    }
    static class BracketDecorator extends MessageWrapper {
        BracketDecorator(Message inner) { super(inner); }
        public String text() { return "[" + inner.text() + "]"; }
    }
    static class UppercaseDecorator extends MessageWrapper {
        UppercaseDecorator(Message inner) { super(inner); }
        public String text() { return inner.text().toUpperCase(); }
    }

    public static void main(String[] args) {
        Message message = new BracketDecorator(new UppercaseDecorator(new PlainMessage("hello")));
        System.out.println(message.text());
    }
}
