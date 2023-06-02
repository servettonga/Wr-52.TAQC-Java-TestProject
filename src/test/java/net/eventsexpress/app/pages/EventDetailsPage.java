package net.eventsexpress.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.eventsexpress.app.driver.DriverManager;

public class EventDetailsPage {
    protected static final String EVENT_PHOTO_XPATH = "//img[contains(@id,'eventFullPhoto')]";
    protected static final String EVENT_NAME_XPATH = "//span[@class='title']";
    protected static final String EVENT_DATE_XPATH = "//time/..";
    protected static final String EVENT_LOCATION_XPATH = "//div[@class='text-block']//div";
    protected static final String EVENT_DESCRIPTION_XPATH = "//div[contains(@class, 'text-box-big')]";
    protected static final String JOIN_BUTTON_XPATH = "//button[contains(@class, 'join-leave')]";

    @FindBy(xpath = EVENT_NAME_XPATH)
    private WebElement eventName;

    @FindBy(xpath = EVENT_DATE_XPATH)
    private WebElement eventDate;

    @FindBy(xpath = EVENT_LOCATION_XPATH)
    private List<WebElement> eventLocation;

    @FindBy(xpath = EVENT_DESCRIPTION_XPATH)
    private WebElement eventDescription;

    public EventDetailsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getEventName() {
        return eventName.getText();
    }

    public String getEventDate() {
        return eventDate.getText();
    }

    public String getEventLocation() {
        List<String> locations = new ArrayList<>();
        for (WebElement element : eventLocation) {
            if (!element.getText().isEmpty()) {
                locations.add(element.getText());
            }
        }
        return String.join(", ", locations);
    }

    public String getEventDescription() {
        return eventDescription.getText();
    }

}
