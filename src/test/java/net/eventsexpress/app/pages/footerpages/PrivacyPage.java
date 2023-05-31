package net.eventsexpress.app.pages.footerpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.eventsexpress.app.driver.DriverManager;

public class PrivacyPage {
    protected static final String PRIVACY_HEADING_CSS = ".privacy h1";

    @FindBy(css = PRIVACY_HEADING_CSS)
    private WebElement privacyHeading;

    public PrivacyPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getPrivacyHeading() {
        return privacyHeading.getText();
    }

}
