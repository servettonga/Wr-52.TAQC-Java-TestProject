package net.eventsexpress.app;

import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class TestSetUp {
    private static Configurations configs = new Configurations();
    private static Configuration config;
    private static String driverOption;

    public static WebDriver getDriver() {
        // Get the default driver for BaseWrapper
        try {
            config = configs.properties(new File("src/main/java/net/eventsexpress/app/Config/app.properties"));
            driverOption = config.getString("driver");
        }
        catch (ConfigurationException cex) {
            System.out.println("Configuration file not found");
            System.exit(1);
        }
        switch (driverOption) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.edge.driver", "src/main/resources/geckodriver.exe");
                return new FirefoxDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver");
                return new EdgeDriver();
            default:
                throw new RuntimeException("Invalid driver");
        }
    }
}
