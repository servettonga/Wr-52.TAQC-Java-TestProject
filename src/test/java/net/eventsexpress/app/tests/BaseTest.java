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
    public static final Dotenv dotenv = Dotenv.load();
    public static final User regularUser = new User(dotenv.get("EMAIL"), dotenv.get("PASSWORD"), true);
    public static final User admin = new User(dotenv.get("ADMIN_EMAIL"), dotenv.get("ADMIN_PASS"), true);
    public static final User newUser = newUser();
    public static final User invalidUser = new User("anyemail@mail.com", "XXXXXXXXXXX", false);
    public static final User unconfirmedUser = new User(dotenv.get("UNCONFIRMED_ACCOUNT_EMAIL"),
            dotenv.get("UNCONFIRMED_ACCOUNT_PASSWORD"), true);

    @Step("Go to the base URL")
    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getDriver();
        DriverManager.goToHomePage();
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
