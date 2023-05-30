package net.eventsexpress.app.tests;

import org.testng.annotations.Test;

import net.eventsexpress.app.pages.Header;
import net.eventsexpress.app.utils.Utils;

public class SamplePageTest extends TestSetUp {
    // Sample test class

    @Test
    public void a_validLoginTest() {
        Header.login(EMAIL, PASSWORD);
        Header.assertUserLoggedIn();
        Utils.sleep(1000);
    }

    @Test
    public void b_invalidLoginTest() {
        Header.login(NEW_EMAIL, NEW_PASSWORD);
        Header.assertUserNotLoggedIn();
        Utils.sleep(1000);
    }

    @Test
    public void c_registerTest() {
        String expected = "Your register was successfull. Please confirm your email.";
        Header.register(NEW_EMAIL, NEW_PASSWORD);
        Header.assertRegistrationSuccess(expected);
        Utils.sleep(1000);
    }

}
