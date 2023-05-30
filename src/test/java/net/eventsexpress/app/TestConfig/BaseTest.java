package net.eventsexpress.app.TestConfig;

import net.eventsexpress.app.common.BaseWrapper;
import net.eventsexpress.app.common.DriverManager;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class BaseTest {

    public BaseWrapper base;
    public Dotenv dotenv;
    public String EMAIL;
    public String PASSWORD;
    public String NEW_EMAIL;
    public String NEW_PASSWORD;

    public BaseTest() {
        dotenv = Dotenv.load();
        EMAIL = dotenv.get("EMAIL");
        PASSWORD = dotenv.get("PASSWORD");
        createRandomUser();
    }

    @BeforeMethod
    public void setUp() {
        base = new BaseWrapper();
    }

    @AfterMethod
    public void tearDown() {
        base.quit();
        DriverManager.remoteDriver();
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
