package net.eventsexpress.app.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.Header;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Registration test with valid data")
    @Description("Assert that user can register with valid data")
    public void validDataRegisters() {
        String expected = "Your register was successfull. Please confirm your email.";
        new Header()
                .register(newUser)
                .assertRegistrationSuccess(expected);
    }

}
