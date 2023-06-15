package net.eventsexpress.app.tests;

import static net.eventsexpress.app.utils.Utils.newUser;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import net.eventsexpress.app.driver.DriverManager;
import net.eventsexpress.app.utils.User;


abstract public class BaseTest {
    public static final Dotenv DOTENV = Dotenv.load();
    public static final User admin = new User(DOTENV.get("EMAIL"), DOTENV.get("PASSWORD"));
    public static final User newUser = newUser();
    public static final User invalidUser = new User("anyemail@mail.com", "XXXXXXXXXXX");
    public static final User unconfirmedUser = new User(DOTENV.get("UNCONFIRMED_ACCOUNT_EMAIL"),
            DOTENV.get("UNCONFIRMED_ACCOUNT_PASSWORD"));

    @Step("Go to the base URL")
    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getDriver();
        DriverManager.goToSite();
    }

    @Step("Quit driver")
    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile =
                    ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment(testResult.getName(), FileUtils.openInputStream(scrFile));
        }
        DriverManager.quit();
    }

}
