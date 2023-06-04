package net.eventsexpress.app.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.Header;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("A valid user can login to the application")
    @Story("Valid username and password login test")
    public void validUserLogin() {
        new Header()
                .login(admin)
                .assertUserLoggedIn();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.BLOCKER)
    @Description("An invalid user can not login to the application")
    @Story("Invalid username and password login test")
    public void invalidUserLoginFails() {
        new Header()
                .login(invalidUser)
                .assertIncorrectLogin();
    }

    @Test(priority = 3)
    public void registeredUserTryLoginWithoutConfirmingEmail() {
        String expected = UNCONFIRMED_ACCOUNT_EMAIL + " is not confirmed, please confirm";
        new Header()
                .login(UNCONFIRMED_ACCOUNT_EMAIL, UNCONFIRMED_ACCOUNT_PASSWORD)
                .assertLoginWithoutConfirmation(expected);
    }
}
