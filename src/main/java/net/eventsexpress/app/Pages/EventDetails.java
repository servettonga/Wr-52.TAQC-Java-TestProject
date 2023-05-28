package net.eventsexpress.app.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.eventsexpress.app.Common.BaseWrapper;

public class EventDetails extends BaseWrapper{
    String EVENT_PHOTO_XPATH = "//img[contains(@id,'eventFullPhoto')]";
    String EVENT_NAME_XPATH = "//span[@class='title']";
    String EVENT_DATE_XPATH = "//time/..";
    String EVENT_LOCATION_XPATH = "//div[@class='text-block']//div";
    String EVENT_DESCRIPTION_XPATH = "//div[contains(@class, 'text-box-big')]";
    String JOIN_BUTTON_XPATH = "//button[contains(@class, 'join-leave')]";

    public EventDetails(WebDriver driver) {
        super(driver);
    }

    public String getEventName() {
        return findElementByXpath(EVENT_NAME_XPATH).getText();
    }

    public String getEventDate() {
        return findElementByXpath(EVENT_DATE_XPATH).getText();
    }

    public String getEventLocation() {
        List<WebElement> elements = findElementsByXpath(EVENT_LOCATION_XPATH);
        List<String> locations = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                locations.add(element.getText());
            }
        }
        return String.join(", ", locations);
    }

    public String getEventDescription() {
        return findElementByXpath(EVENT_DESCRIPTION_XPATH).getText();
    }

    public void clickJoinButton() {
        findElementByXpath(JOIN_BUTTON_XPATH).click();
    }

}
