package net.eventsexpress.app.tests;

import org.testng.annotations.Test;

import net.eventsexpress.app.pages.Header;

public class SamplePageTest extends BaseTest {
    // Sample test class

    @Test(priority = 1)
    public void validLoginTest() {
        Header.login(EMAIL, PASSWORD);
        Header.assertUserLoggedIn();
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        Header.login(NEW_EMAIL, NEW_PASSWORD);
        Header.assertIncorrectLogin();
    }

    @Test(priority = 3)
    public void registerTest() {
        String expected = "Your register was successfull. Please confirm your email.";
        Header.register(NEW_EMAIL, NEW_PASSWORD);
        Header.assertRegistrationSuccess(expected);
    }

}
