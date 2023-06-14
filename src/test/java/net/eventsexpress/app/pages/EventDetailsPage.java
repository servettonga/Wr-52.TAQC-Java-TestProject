package net.eventsexpress.app.pages;

import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventDetailsPage {
    private final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    private final WebDriverWait wait =
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
    protected static final String EVENT_PHOTO_XPATH = "//img[contains(@id,'eventFullPhoto')]";
    protected static final String EVENT_NAME_XPATH = "//span[@class='title']";
    protected static final String EVENT_DATE_XPATH = "//time/..";
    protected static final String EVENT_LOCATION_XPATH = "//div[@class='text-block']//div";
    protected static final String EVENT_DESCRIPTION_XPATH = "//div[contains(@class, 'text-box-big')]";
    protected static final String JOIN_BUTTON_XPATH = "//button[contains(@class, 'join-leave')]";
    protected static final String COMMENT_TO_EVENT_XPATH = "//input[@name='text']";
    protected static final String ADD_COMMENT_BUTTON = "//button[@value='Add']";
    protected static final String ALL_COMMENTS = "//div[@class='comment-container']//p[2]";
    protected static final String DELETE_LAST_COMMENT = "(//button[@aria-label='Delete'])[last()]";

    @FindBy(xpath = EVENT_NAME_XPATH)
    private WebElement eventName;

    @FindBy(xpath = EVENT_DATE_XPATH)
    private WebElement eventDate;

    @FindBy(xpath = EVENT_LOCATION_XPATH)
    private List<WebElement> eventLocation;

    @FindBy(xpath = EVENT_DESCRIPTION_XPATH)
    private WebElement eventDescription;

    @FindBy(xpath = COMMENT_TO_EVENT_XPATH)
    private WebElement commentFieldInput;

    @FindBy(xpath = ADD_COMMENT_BUTTON)
    private WebElement commentButton;

    @FindBy(xpath = DELETE_LAST_COMMENT)
    private WebElement deleteLastComment;

    @FindBy(xpath = ALL_COMMENTS)
    private List<WebElement> allComments;

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

    @Step("Add comment to the event details")
    public EventDetailsPage addCommentToEvent() {
        WebElement commentField = wait.until(ExpectedConditions.visibilityOf(commentFieldInput));
        commentField.sendKeys("test4");
        commentButton.click();
        return this;
    }

    @Step("Assert that comment added to the event details")
    public EventDetailsPage assertAddedComment() {
        WebElement lastCommentField = wait.until(ExpectedConditions.visibilityOf(commentFieldInput));
        assertThat(this.getEventComments().get(this.getEventComments().size() - 1)).isEqualTo("test4");
        this.deleteCreatedComment();
        return this;
    }

    public List<String> getEventComments() {
        List<String> comments = new ArrayList<>();
        for (WebElement element : allComments) {
            if (!element.getText().isEmpty()) {
                comments.add(element.getText());
            }
        }
        return comments;
    }

    public void deleteCreatedComment(){
        WebElement lastCommentDelete = wait.until(ExpectedConditions.visibilityOf(deleteLastComment));
        lastCommentDelete.click();
    }

}
