package net.eventsexpress.app.tests;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.Header;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid username and password login")
    @Description("Assert that a valid user can login to the application")
    public void validUserLogin() {
        new Header()
                .login(admin)
                .assertUserLoggedIn();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.BLOCKER)
    @Story("Invalid username and password login")
    @Description("Assert that an invalid user can not login to the application")
    public void invalidUserLoginFails() {
        new Header()
                .login(invalidUser)
                .assertIncorrectLogin();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Unconfirmed user login")
    @Description("Assert that unconfirmed user can not login to the application")
    public void registeredUserTryLoginWithoutConfirmingEmail() {
        String expected = unconfirmedUser.username() + " is not confirmed, please confirm";
        new Header()
                .login(unconfirmedUser)
                .assertLoginWithoutConfirmation(expected);
    }

}
