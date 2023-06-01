package net.eventsexpress.app.tests;

import org.testng.annotations.Test;

import net.eventsexpress.app.pages.Header;

public class RegisterTests extends BaseTest {

    @Test(priority = 1)
    public void validDataRegisters() {
        String expected = "Your register was successfull. Please confirm your email.";
        new Header()
                .register(NEW_EMAIL, NEW_PASSWORD)
                .assertRegistrationSuccess(expected);
    }

}
