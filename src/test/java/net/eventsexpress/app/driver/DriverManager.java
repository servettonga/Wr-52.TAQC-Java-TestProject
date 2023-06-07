package net.eventsexpress.app.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Set;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static WebDriver driver;
    private static final String driverOption = System.getProperty("driver").toLowerCase();
    private static final Boolean headless = Boolean.valueOf(System.getProperty("headless"));

    public static WebDriver getDriver() {
        return driver == null ? driver = createDriver() : driver;
    }

    private static WebDriver createDriver() {
        // Get the default driver
        switch (driverOption) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--start-maximized");
                if (headless) {
                    for (String arg : new String[] {"--headless", "--no-sandbox",
                            "--disable-dev-shm-usage"}) {
                        chromeOptions.addArguments(arg);
                    }
                }
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");
                firefoxOptions.addArguments("--start-maximized");
                return new FirefoxDriver(firefoxOptions);
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("-inprivate");
                edgeOptions.addArguments("start-maximized");
                return new EdgeDriver(edgeOptions);
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            default:
                throw new RuntimeException("Invalid driver");
        }
    }

    public static void quit() {
        // Method for quit driver
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String getCurrentUrl() {
        // Method for get current url
        return driver.getCurrentUrl();
    }

    public static void goToSite(String URL) {
        // Method for open site
        try {
            Set<String> tabs = driver.getWindowHandles();
            if (tabs.size() == 0) {
                driver.switchTo().newWindow(WindowType.TAB);
            }
            driver.get(URL);
        } catch (TimeoutException e) {
            throw new RuntimeException("Site downloading failed, timeout");
        }
    }

    public static Dictionary<String, String> getBrowserInfo() {
        getDriver();
        Dictionary<String, String> browser = new Hashtable<>();
        browser.put("name", ((RemoteWebDriver) driver).getCapabilities().getBrowserName());
        browser.put("version", ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion());
        return browser;
    }
}
