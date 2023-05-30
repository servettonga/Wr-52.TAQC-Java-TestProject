package net.eventsexpress.app.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.cdimascio.dotenv.Dotenv;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import net.eventsexpress.app.utils.Utils;

public class TestSetUp {
    public Dotenv dotenv;
    public String EMAIL;
    public String PASSWORD;
    public String NEW_EMAIL;
    public String NEW_PASSWORD;
    public String baseURL = ConfigurationManager.getConfig().getString("baseURL");

    public TestSetUp() {
        dotenv = Dotenv.load();
        EMAIL = dotenv.get("EMAIL");
        PASSWORD = dotenv.get("PASSWORD");
        NEW_EMAIL = Utils.randomUser().get(0);
        NEW_PASSWORD = Utils.randomUser().get(1);
    }

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
