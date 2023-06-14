package net.eventsexpress.app.utils;

public record User(String username, String password) {

    @Override
    public String toString() {
        String usernamePrefix = "";
        usernamePrefix = username.substring(0, Math.min(username.length(), 2));
        return "Username: " + usernamePrefix + "*********\nPassword: **********";
    }
}
