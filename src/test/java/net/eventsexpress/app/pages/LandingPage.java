package net.eventsexpress.app.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.eventsexpress.app.driver.DriverManager;

public class LandingPage {
    // Hero
    protected static final String CREATE_EVENT_BTN_XPATH = "//button[contains(text(), 'Create event')]";
    protected static final String FIND_EVENT_BTN_XPATH = "//a[text()='Find event']";
    protected static final String JOIN_EVENTSEXPRESS_BTN_XPATH = "//button[text()='Join EventsExpress']";
    // Upcoming Events
    protected static final String JOIN_EVENT_BTN_XPATH = "//a[text()='Join event']";
    protected static final String EXPlORE_MORE_EVENTS_BTN_XPATH = "//a[text()='Explore more events']";
    // UI
    protected static final String BACKGROUND_IMAGE_CSS = "article[style~='background-image:']";

    @FindBy(css = BACKGROUND_IMAGE_CSS)
    private WebElement backgroundImage;

    @FindBy(xpath = FIND_EVENT_BTN_XPATH)
    private WebElement findEventButton;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getBackgroundImage() {
        Pattern pattern = Pattern.compile("\\/([^\\/]+\\.jpg)");
        String input = backgroundImage.getAttribute("style");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public LandingPage findEvent() {
        findEventButton.click();
        return this;
    }


}
