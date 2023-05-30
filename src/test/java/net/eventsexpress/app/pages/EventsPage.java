package net.eventsexpress.app.pages;

import java.util.List;
import org.openqa.selenium.WebElement;

import net.eventsexpress.app.base.Base;

public class EventsPage {
    protected static String ADMIN_MENU_CSS = "#sub-nav";
    protected static String NAV_PAGE_TITLE_CSS = "span.nav-item-text";

    public void admingPanel(String pageName) {
        /*
         * Method for click on page depending on page_title value.
         * Pages of Admin Panel:
         * "Categories" - Edit_category
         * "UnitsOfMeasuring" - Units_of_measuring
         * "Users" - User
         * "Notification Templates" - NotificationPage
         * "Tracks" - Track
         */
        List<WebElement> navItems = Base.findElementsByCSS(ADMIN_MENU_CSS);
        for (WebElement navItem : navItems) {
            if (navItem.getText().equals(pageName)) {
                navItem.click();
                break;
            }
        }
    }

    public void navigation(String pageName) {
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
        List<WebElement> navItems = Base.findElementsByCSS(NAV_PAGE_TITLE_CSS);
        for (WebElement navItem : navItems) {
            if (navItem.getText().equals(pageName)) {
                navItem.click();
                break;
            }
        }
    }

}
