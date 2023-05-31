package net.eventsexpress.app.tests;

import org.testng.annotations.Test;

import net.eventsexpress.app.pages.Header;

public class SamplePageTest extends BaseTest {
    // Sample test class

    @Test(priority = 1)
    public void validLoginTest() {
        new Header()
                .login(EMAIL, PASSWORD)
                .assertUserLoggedIn();
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        new Header()
                .login(NEW_EMAIL, NEW_PASSWORD)
                .assertIncorrectLogin();
    }

    @Test(priority = 3)
    public void registerTest() {
        String expected = "Your register was successfull. Please confirm your email.";
        new Header()
                .register(NEW_EMAIL, NEW_PASSWORD)
                .assertRegistrationSuccess(expected);
    }

}
