package net.eventsexpress.app.Pages;

import org.openqa.selenium.WebDriver;

import net.eventsexpress.app.Common.BaseWrapper;

public class LandingPage extends BaseWrapper{
    String CREATE_EVENT_BTN_XPATH = "//button[contains(text(), 'Create event')]";
    String JOIN_EVENTSEXPRESS_BTN_XPATH = "//button[text()='Join EventsExpress']";

    public LandingPage(WebDriver driver) {
        super(driver);
    }

}
