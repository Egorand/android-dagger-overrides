package me.egorand.daggeroverrides.model;

public class HelloGreetingGenerator implements GreetingGenerator {

    private static final String GREETING_TEMPLATE = "Hello, %s!";

    @Override public String generateGreeting(String name) {
        return String.format(GREETING_TEMPLATE, name);
    }
}
