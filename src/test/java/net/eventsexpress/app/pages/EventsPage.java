package net.eventsexpress.app.pages;

import io.qameta.allure.Step;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import io.qameta.allure.Step;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.eventsexpress.app.driver.DriverManager;
import org.testng.Assert;

public class EventsPage {
    private final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    private final WebDriverWait wait =
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
    protected static final String ADMIN_MENU_CSS = "#sub-nav";
    protected static final String NAV_PAGE_TITLE_CSS = "span.nav-item-text";
    protected static final String UPCOMING_PUBLIC_EVENT_CSS = "img[alt~='Event']";
    protected static final String EVENT_DETAILS_LOGO_XPATH = "//img[contains(@id,'eventFullPhoto')]";

    @FindBy(css = ADMIN_MENU_CSS)
    private List<WebElement> adminPanelPages;

    @FindBy(css = NAV_PAGE_TITLE_CSS)
    private List<WebElement> navigationPages;

    @FindBy(css = UPCOMING_PUBLIC_EVENT_CSS)
    private WebElement upcomingEventLogo;

    @FindBy(xpath = EVENT_DETAILS_LOGO_XPATH)
    private WebElement eventDetailsFullLogo;

    public EventsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

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
