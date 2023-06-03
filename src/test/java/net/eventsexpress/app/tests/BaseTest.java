package net.eventsexpress.app.tests;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import net.eventsexpress.app.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest {
    public static final Dotenv DOTENV = Dotenv.load();
    public static final String EMAIL = DOTENV.get("EMAIL");
    public static final String PASSWORD = DOTENV.get("PASSWORD");
    public static final String NEW_EMAIL = Utils.randomUser().get(0);
    public static final String NEW_PASSWORD = Utils.randomUser().get(1);
    public static final String BASE_URL = ConfigurationManager.getConfig().getString("BASE_URL");

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getDriver();
        DriverManager.goToSite(BASE_URL);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment(testResult.getName(), FileUtils.openInputStream(scrFile));
        }
        DriverManager.quit();
    }

}
