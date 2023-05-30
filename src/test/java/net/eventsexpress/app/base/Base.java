package net.eventsexpress.app.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;

import java.time.Duration;
import java.util.List;

public class Base {
    protected static WebDriver driver = DriverManager.getDriver();
    protected static int timeout = ConfigurationManager.getConfig().getInt("elementTimeOut");
    protected static Actions action = new Actions(driver);
    protected static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static WebElement findElementByCSS(String locator) {
        // Method for search element by css selector with wait
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public static WebElement findElementByXpath(String locator) {
        // Method for search element by xpath with wait
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public static WebElement findElementById(String locator) {
        // Method for search element by id with wait
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public static WebElement findElementByName(String locator) {
        // Method for search element by name with wait
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
            return element;
        } catch (TimeoutException e) {
            throw new RuntimeException("Element was not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element " + locator + " was not found");
        }
    }

    public static List<WebElement> findElementsByCSS(String locator) {
        // Method for search elements by css selector with wait
        try {
            List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
            return elements;
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public static List<WebElement> findElementsByXpath(String locator) {
        // Method for search elements by xpath with wait
        try {
            List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
            return elements;
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public static List<WebElement> findElementsById(String locator) {
        // Method for search elements by id with wait
        try {
            List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locator)));
            return elements;
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public static List<WebElement> findElementsByName(String locator) {
        // Method for search elements by name with wait
        try {
            List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locator)));
            return elements;
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements were not found during " + (timeout) + " seconds");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Elements " + locator + " were not found");
        }
    }

    public static void scrollToElementCSS(String locator) {
        // Method for scroll to element
        WebElement elementToScrooll = findElementByCSS(locator);
        action.moveToElement(elementToScrooll).perform();
    }

    public static void scrollToElementXpath(String locator) {
        // Method for scroll to element
        WebElement elementToScrooll = findElementByXpath(locator);
        action.moveToElement(elementToScrooll).perform();
    }

    public static void waitUntilCSSElementIsVisible(String locator) {
        // Method for wait until element is visible
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static void waitUntilXpathElementIsVisible(String locator) {
        // Method for wait until element is visible
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void clickJS(WebElement webElement) {
        // Method for click JS
        js.executeScript("arguments[0].click();", webElement);
    }

}
