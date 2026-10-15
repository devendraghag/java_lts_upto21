package com.example.designpattern.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Dynamic Proxy: Java creates a proxy at runtime that logs and forwards interface calls.
public class Proxy02LoggingProxyDemo {
    interface Greeting { String sayHello(String name); }
    static class GreetingService implements Greeting {
        public String sayHello(String name) { return "Hello, " + name; }
    }

    public static void main(String[] args) {
        Greeting target = new GreetingService();
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(), new Class<?>[]{Greeting.class},
                new InvocationHandler() {
                    public Object invoke(Object proxyObject, Method method, Object[] arguments) throws Throwable {
                        System.out.println("Before " + method.getName());
                        Object result = method.invoke(target, arguments);
                        System.out.println("After " + method.getName());
                        return result;
                    }
                });
        System.out.println(proxy.sayHello("Mira"));
    }
}
