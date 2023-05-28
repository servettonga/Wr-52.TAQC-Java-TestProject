package net.eventsexpress.app.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.eventsexpress.app.Common.BaseWrapper;

public class Navigation extends BaseWrapper{
    String NAV_PAGE_TITLE_CSS = "span.nav-item-text";

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public void goToPage(String pageName) {
        /*
            Method for click on page depending on page_title value.
            page_title values for admin:
                'Home' - Home page
                'Comuna' - Comuna page
                'Admin' - Admin page
                'Issues' - Issues page
            page_title for user:
                'Home' - Home page
                'Profile' - Profile page
                'Draft' - Drafts page
                'Search Users' - Search/users page
                'Recurrent Events' - eventSchedules page
                'Contact us' - contactAdmin page
                'Comuna' Comuna page
        */
        List<WebElement>  navItems = findElementsByCSS(NAV_PAGE_TITLE_CSS);
        for (WebElement navItem : navItems) {
            if (navItem.getText().equals(pageName)) {
                navItem.click();
                break;
            }
        }
    }

}
