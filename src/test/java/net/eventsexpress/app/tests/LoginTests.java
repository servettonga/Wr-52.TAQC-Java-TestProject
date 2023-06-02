package net.eventsexpress.app.tests;

import org.testng.annotations.Test;

import net.eventsexpress.app.pages.Header;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    public void validUserLogsIn() {
        new Header()
                .login(EMAIL, PASSWORD)
                .assertUserLoggedIn();
    }

    @Test(priority = 2)
    public void invalidUserLoginFails() {
        String expected = "Incorrect login or password";
        new Header()
                .login(NEW_EMAIL, NEW_PASSWORD)
                .assertIncorrectLogin(expected);
    }

}
