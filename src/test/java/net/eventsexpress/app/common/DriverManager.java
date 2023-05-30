package net.eventsexpress.app.common;

import net.eventsexpress.app.TestConfig.BaseTest;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class DriverManager {

    private static WebDriver driver;
    private static String driverOption;

    public static void goToSite(String pageUrl) {
        // Method for open site
        try {
            driver.get(pageUrl);
        } catch (TimeoutException e) {
            throw new RuntimeException("Site downloading failed, timeout");
        }
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        driver = createDriver();
        return driver;
    }

    private static RemoteWebDriver createDriver() {
        // Get the default driver for BaseWrapper
        Configuration config = ConfigurationManager.getConfig();
        driverOption = config.getString("driver");

        switch (driverOption) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver-113.exe");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/geckodriver.exe");
                return new FirefoxDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/msedgedriver");
                return new EdgeDriver();
            default:
                throw new RuntimeException("Invalid driver");
        }
    }

    public static void remoteDriver() {
        driver = null;
    }
}
