package net.eventsexpress.app.pages;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;


public class EventDetailsPage extends BasePage {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement eventName;

    @FindBy(xpath = "//time/..")
    private WebElement eventDate;

    @FindBy(xpath = "//div[@class='text-block']//div")
    private List<WebElement> eventLocation;

    @FindBy(xpath = "//div[contains(@class, 'text-box-big')]")
    private WebElement eventDescription;

    @FindBy(xpath = "//input[@name='text']")
    private WebElement commentFieldInput;

    @FindBy(xpath = "//img[contains(@id,'eventFullPhoto')]")
    private WebElement eventPhoto;

    @FindBy(xpath = "//button[contains(@class, 'join-leave')]")
    private WebElement joinButton;

    @FindBy(xpath = "//button[@value='Add']")
    private WebElement commentButton;

    @FindBy(xpath = "(//button[@aria-label='Delete'])[last()]")
    private WebElement deleteLastComment;

    @FindBy(xpath = "//div[@class='comment-container']//p[2]")
    private List<WebElement> allComments;


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
        wait.until(ExpectedConditions.visibilityOf(commentFieldInput));
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

    @Step("Click on join button")
    public EventDetailsPage clickJoinButton() {
        joinButton.click();
        return this;
    }

    public String getEventPhoto() {
        return eventPhoto.getAttribute("src");
    }

}
