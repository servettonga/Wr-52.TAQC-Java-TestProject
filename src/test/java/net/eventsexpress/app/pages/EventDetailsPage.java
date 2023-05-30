package net.eventsexpress.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.eventsexpress.app.base.Base;

public class EventDetailsPage {
    protected static String EVENT_PHOTO_XPATH = "//img[contains(@id,'eventFullPhoto')]";
    protected static String EVENT_NAME_XPATH = "//span[@class='title']";
    protected static String EVENT_DATE_XPATH = "//time/..";
    protected static String EVENT_LOCATION_XPATH = "//div[@class='text-block']//div";
    protected static String EVENT_DESCRIPTION_XPATH = "//div[contains(@class, 'text-box-big')]";
    protected static String JOIN_BUTTON_XPATH = "//button[contains(@class, 'join-leave')]";

    public String getEventName() {
        return Base.findElementByXpath(EVENT_NAME_XPATH).getText();
    }

    public String getEventDate() {
        return Base.findElementByXpath(EVENT_DATE_XPATH).getText();
    }

    public String getEventLocation() {
        List<WebElement> elements = Base.findElementsByXpath(EVENT_LOCATION_XPATH);
        List<String> locations = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                locations.add(element.getText());
            }
        }
        return String.join(", ", locations);
    }

    public String getEventDescription() {
        return Base.findElementByXpath(EVENT_DESCRIPTION_XPATH).getText();
    }

    public void clickJoinButton() {
        Base.findElementByXpath(JOIN_BUTTON_XPATH).click();
    }

}
