package net.eventsexpress.app.pages;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;
import net.eventsexpress.app.driver.DriverManager;


public class EventsPage extends BasePage {

    @FindBy(css = "#sub-nav")
    private List<WebElement> adminPanelPages;

    @FindBy(css = "span.nav-item-text")
    private List<WebElement> navigationPages;

    @FindBy(css = "img[alt~='Event']")
    private WebElement upcomingEventLogo;

    @FindBy(xpath = "//img[contains(@id,'eventFullPhoto')]")
    private WebElement eventDetailsFullLogo;


    public EventsPage adminPanel(String pageName) {
        /*-
         * Method for click on page depending on page_title value.
         * Pages of Admin Panel:
         * "Categories" - Edit_category
         * "UnitsOfMeasuring" - Units_of_measuring
         * "Users" - User
         * "Notification Templates" - NotificationPage
         * "Tracks" - Track
         */
        for (WebElement navItem : adminPanelPages) {
            if (navItem.getText().equals(pageName)) {
                navItem.click();
                break;
            }
        }
        return this;
    }

    public EventsPage navigation(String pageName) {
        /*-
         * Method for click on page depending on page_title value.
         * page_title values for admin:
         * 'Home' - Home page
         * 'Comuna' - Comuna page
         * 'Admin' - Admin page
         * 'Issues' - Issues page
         * page_title for user:
         * 'Home' - Home page
         * 'Profile' - Profile page
         * 'Draft' - Drafts page
         * 'Search Users' - Search/users page
         * 'Recurrent Events' - eventSchedules page
         * 'Contact us' - contactAdmin page
         * 'Comuna' Comuna page
         */
        for (WebElement navItem : navigationPages) {
            if (navItem.getText().equals(pageName)) {
                navItem.click();
                break;
            }
        }
        return this;
    }

    @Step("Assert that Event page is opened")
    public EventsPage assertEventsPageOpened() {
        assertThat(DriverManager.getCurrentUrl()).contains("/home/events");
        return this;
    }

    @Step("Open event details")
    public EventsPage openEventDetails() {
        WebElement eventLogo = wait.until(ExpectedConditions.visibilityOf(upcomingEventLogo));
        assertThat(eventLogo.isDisplayed()).withFailMessage("Event is not displayed");
        eventLogo.click();
        return this;
    }

    @Step("Assert that upcoming event logo is displayed")
    public EventsPage assertUpcomingEventDetails() {
        WebElement eventDetailsLogo = wait.until(ExpectedConditions.visibilityOf(eventDetailsFullLogo));
        assertThat(eventDetailsLogo.isDisplayed()).withFailMessage("Event is not displayed");
        return this;
    }

}
