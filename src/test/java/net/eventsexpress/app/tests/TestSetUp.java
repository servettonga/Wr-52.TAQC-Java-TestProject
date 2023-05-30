package net.eventsexpress.app.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.cdimascio.dotenv.Dotenv;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import net.eventsexpress.app.utils.Utils;

public class TestSetUp {
    public static final Dotenv dotenv = Dotenv.load();
    public static final String EMAIL = dotenv.get("EMAIL");
    public static final String PASSWORD = dotenv.get("PASSWORD");
    public static final String NEW_EMAIL = Utils.randomUser().get(0);
    public static final String NEW_PASSWORD = Utils.randomUser().get(1);
    public static final String baseURL = ConfigurationManager.getConfig().getString("baseURL");

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getDriver();
        DriverManager.goToSite(baseURL);
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.quit();
    }

}
