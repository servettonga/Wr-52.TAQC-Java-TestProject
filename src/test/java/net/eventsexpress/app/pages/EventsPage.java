package net.eventsexpress.app.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.eventsexpress.app.driver.DriverManager;

public class EventsPage {
    protected static final String ADMIN_MENU_CSS = "#sub-nav";
    protected static final String NAV_PAGE_TITLE_CSS = "span.nav-item-text";

    @FindBy(css = ADMIN_MENU_CSS)
    private List<WebElement> adminPanelPages;

    @FindBy(css = NAV_PAGE_TITLE_CSS)
    private List<WebElement> navigationPages;

    public EventsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public EventsPage adminPanel(String pageName) {
        /*
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
        /*
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

}
