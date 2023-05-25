package net.eventexpress.app.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.Configuration;

import java.io.File;
import java.time.Duration;


public class BaseWrapper {
    private Configurations configs = new Configurations();
    private Configuration config;
    String driverOption;
    WebDriver driver;

    private void loadConfig() {
        try {
            config = configs.properties(new File("src/main/java/net/eventexpress/app/Config/app.properties"));
        }
        catch (ConfigurationException cex) {
            System.out.println("Configuration file not found");
            System.exit(1);
        }
    }

    public BaseWrapper() {
        loadConfig();
        driverOption = config.getString("driver");
        switch (driverOption) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.edge.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver");
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid driver");
        }
        driver.manage().window().maximize();
    }


    public void goToSite() {
        // Method for open site
        try {
            driver.get(config.getString("baseURL"));
        }
        catch (TimeoutException e) {
            throw new RuntimeException("Site downloading failed, timeout");
        }
    }

    public WebElement findElementByCSS(String locator) {
        // Method for search element by css selector with wait
        int timeout = config.getInt("elementTimeOut");
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
            return element;
        }
        catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        }
        catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }
}
