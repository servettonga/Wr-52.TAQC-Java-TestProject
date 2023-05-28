package net.eventsexpress.app.Pages.FooterPages;

import org.openqa.selenium.WebDriver;

import net.eventsexpress.app.Common.BaseWrapper;

public class Privacy extends BaseWrapper{
    String PRIVACY_HEADING_CSS = ".privacy h1";

    public Privacy(WebDriver driver) {
        super(driver);
    }

    public String getPrivacyHeading() {
        return findElementByCSS(PRIVACY_HEADING_CSS).getText();
    }

}
