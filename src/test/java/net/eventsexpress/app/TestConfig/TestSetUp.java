package net.eventsexpress.app.TestConfig;

import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.cdimascio.dotenv.Dotenv;
import net.eventsexpress.app.Common.BasePage;

import java.io.File;

public class TestSetUp {
    private static Configurations configs;
    private static Configuration config;
    private static String driverOption;
    public BasePage base;
    public Dotenv dotenv;
    public String EMAIL;
    public String PASSWORD;
    public String NEW_EMAIL;
    public String NEW_PASSWORD;


    public TestSetUp() {
        dotenv = Dotenv.load();
        EMAIL = dotenv.get("EMAIL");
        PASSWORD = dotenv.get("PASSWORD");
        configs = new Configurations();
        createRandomUser();
    }

    public static WebDriver getDriver() {
        // Get the default driver for BaseWrapper
        try {
            config = configs.properties(new File("src/test/java/net/eventsexpress/app/TestConfig/test.properties"));
            driverOption = config.getString("driver");
        }
        catch (ConfigurationException cex) {
            System.out.println("Test configuration file not found");
            System.exit(1);
        }
        switch (driverOption) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
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

    public static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createRandomUser() {
        String email = "";
        String password = "";
        final String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
        "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
        "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
        "X", "Y", "Z"};
        final String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        final String[] symbols = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "-", "=", "~"};
        for (int i = 0; i < 5; i++) {
            email += (letters[(int) (Math.random() * letters.length)] + numbers[(int) (Math.random() * numbers.length)]);
            password += (letters[(int) (Math.random() * letters.length)] + numbers[(int) (Math.random() * numbers.length)] + symbols[(int) (Math.random() * symbols.length)]);
        }
        NEW_EMAIL = email + "@gmail.com";
        NEW_PASSWORD = password;
    }

}
