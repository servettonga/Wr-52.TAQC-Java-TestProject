package net.eventexpress.app.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.Configuration;

import java.io.File;
import java.time.Duration;
import java.util.List;


public class BaseWrapper {
    private Configurations configs = new Configurations();
    private Configuration config;
    private String driverOption;
    private WebDriver driver;
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private int timeout;
    private Actions action;


    private void loadConfig() {
        try {
            config = configs.properties(new File("src/main/java/net/eventexpress/app/Config/app.properties"));
            timeout = config.getInt("elementTimeOut");
            driverOption = config.getString("driver");
        }
        catch (ConfigurationException cex) {
            System.out.println("Configuration file not found");
            System.exit(1);
        }
    }

    public BaseWrapper() {
        loadConfig();
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
        action = new Actions(driver);
    }

    public void quit() {
        driver.quit();
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

    public WebElement findElementByXpath(String locator) {
        // Method for search element by xpath with wait
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return element;
        }
        catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        }
        catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public WebElement findElementById(String locator) {
        // Method for search element by id with wait
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
            return element;
        }
        catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        }
        catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public WebElement findElementByName(String locator) {
        // Method for search element by name with wait
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
            return element;
        }
        catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        }
        catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public List<WebElement> findElementsByCSS(String locator) {
        // Method for search elements by css selector with wait
        try {
            List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
            return elements;
        }
        catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        }
        catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public List<WebElement> findElementsByXpath(String locator) {
        // Method for search elements by xpath with wait
        try {
            List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
            return elements;
        }
        catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        }
        catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public void scrollToElementCSS(String locator) {
        // Method for scroll to element
        WebElement elementToScrooll = findElementByCSS(locator);
        action.moveToElement(elementToScrooll).perform();
    }

    public  void scrollToElementXpath(String locator) {
        // Method for scroll to element
        WebElement elementToScrooll = findElementByXpath(locator);
        action.moveToElement(elementToScrooll).perform();
    }

    public String getCurrentUrl() {
        // Method for get current url
        return driver.getCurrentUrl();
    }
}