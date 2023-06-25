package net.eventsexpress.app.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;


public class LandingPage extends BasePage {

    // Hero
    @FindBy(xpath = "//button[contains(text(), 'Create event')]")
    private WebElement createEventButton;

    @FindBy(xpath = "//a[text()='Find event']")
    private WebElement findEventButton;

    @FindBy(xpath = "//button[text()='Join EventsExpress']")
    private WebElement joinEventExpressButton;

    // Upcoming Events
    @FindBy(xpath = "//a[text()='Join event']")
    private WebElement joinEventButton;

    @FindBy(xpath = "//a[text()='Explore more events']")
    private WebElement exploreMoreEventsButton;

    // UI
    @FindBy(css = "article[style~='background-image:']")
    private WebElement backgroundImage;


    public String getBackgroundImage() {
        Pattern pattern = Pattern.compile("\\/([^\\/]+\\.jpg)");
        String input = backgroundImage.getAttribute("style");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    @Step("Click on 'Find event' button")
    public LandingPage clickOnFindEventButton() {
        findEventButton.click();
        return this;
    }

}
