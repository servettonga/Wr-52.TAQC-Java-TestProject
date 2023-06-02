package net.eventsexpress.app.pages.footerpages;

import net.eventsexpress.app.config.ConfigurationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivacyPage {
    private final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    private final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
    protected static final String PRIVACY_HEADING_CSS = ".privacy h1";

    @FindBy(css = PRIVACY_HEADING_CSS)
    private WebElement privacyHeading;

    public PrivacyPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getPrivacyHeading() {
        return privacyHeading.getText();
    }
    public static void assertPrivacyHeadingIsDisplayed() {
        assert Base.findElementByCSS(PRIVACY_HEADING_CSS).isDisplayed()
                : "Privacy Heading is not displayed";
    }

    public PrivacyPage assertPrivacyHeadingIsDisplayed(){
        WebElement heading = wait.until(ExpectedConditions.visibilityOf(privacyHeading));
        assert heading.isDisplayed() : "Privacy Heading  is not displayed";
        return this;
    }

}
