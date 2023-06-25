package net.eventsexpress.app.utils;

public record User(String username, String password, Boolean masked) {

    @Override
    public String toString() {
        String usernamePrefix = "";
        usernamePrefix = username.substring(0, Math.min(username.length(), 2));
        if (masked) {
            return "Username: " + usernamePrefix + "*********\nPassword: **********";
        }
        return "Username: " + username + "\nPassword: " + password;
    }
}
