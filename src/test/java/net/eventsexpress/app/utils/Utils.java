package net.eventsexpress.app.utils;


import com.github.javafaker.Faker;

public class Utils {
    public static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static User newUser() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        User user = new User(email, password);
        return user;
    }
}
