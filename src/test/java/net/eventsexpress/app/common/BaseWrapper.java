package net.eventsexpress.app.common;

import net.eventsexpress.app.TestConfig.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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
    private int timeout;
    private Actions action;
    private JavascriptExecutor js;

    public BaseWrapper() {
        loadConfig();
        DriverManager.getDriver().manage().window().maximize();
        action = new Actions(DriverManager.getDriver());
        js = (JavascriptExecutor) DriverManager.getDriver();
    }

    private void loadConfig() {
        // Gather configuration for BaseWrapper
        try {
            config = configs.properties(new File("src/main/java/net/eventsexpress/app/Config/app.properties"));
            timeout = config.getInt("elementTimeOut");
        } catch (ConfigurationException cex) {
            System.out.println("App configuration file not found");
            System.exit(1);
        }
    }

    public void quit() {
        // Method for quit driver
        DriverManager.getDriver().quit();
    }

    public void close() {
        // Method for close browser
        DriverManager.getDriver().close();
    }

    public void goToSite() {
        // Method for open site
        try {
            DriverManager.getDriver().get(config.getString("baseURL"));
        } catch (TimeoutException e) {
            throw new RuntimeException("Site downloading failed, timeout");
        }
    }

    public WebElement findElementByCSS(String locator) {
        // Method for search element by css selector with wait
        try {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public WebElement findElementByXpath(String locator) {
        // Method for search element by xpath with wait
        try {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public WebElement findElementById(String locator) {
        // Method for search element by id with wait
        try {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public WebElement findElementByName(String locator) {
        // Method for search element by name with wait
        try {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public List<WebElement> findElementsByCSS(String locator) {
        // Method for search elements by css selector with wait
        try {
            List<WebElement> elements = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
            return elements;
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public List<WebElement> findElementsByXpath(String locator) {
        // Method for search elements by xpath with wait
        try {
            List<WebElement> elements = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
            return elements;
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public List<WebElement> findElementsById(String locator) {
        // Method for search elements by id with wait
        try {
            List<WebElement> elements = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locator)));
            return elements;
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public List<WebElement> findElementsByName(String locator) {
        // Method for search elements by name with wait
        try {
            List<WebElement> elements = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locator)));
            return elements;
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public void scrollToElementCSS(String locator) {
        // Method for scroll to element
        WebElement elementToScrooll = findElementByCSS(locator);
        action.moveToElement(elementToScrooll).perform();
    }

    public void scrollToElementXpath(String locator) {
        // Method for scroll to element
        WebElement elementToScrooll = findElementByXpath(locator);
        action.moveToElement(elementToScrooll).perform();
    }

    public String getCurrentUrl() {
        // Method for get current url
        return DriverManager.getDriver().getCurrentUrl();
    }

    public void waitUntilCSSElementIsVisible(String locator) {
        // Method for wait until element is visible
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public void waitUntilXpathElementIsVisible(String locator) {
        // Method for wait until element is visible
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickJS(WebElement webElement) {
        // Method for click JS
        js.executeScript("arguments[0].click();", webElement);
    }

}