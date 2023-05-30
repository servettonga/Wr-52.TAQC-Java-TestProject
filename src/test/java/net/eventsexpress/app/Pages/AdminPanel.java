package net.eventsexpress.app.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.eventsexpress.app.common.BaseWrapper;

public class AdminPanel extends BaseWrapper{

    String ADMIN_MENU_CSS = "#sub-nav";

    public void goToPage(String pageName) {
        /*
            Method for click on page depending on page_title value.
            Pages of Admin Panel:
                "Categories" - Edit_category
                "UnitsOfMeasuring" - Units_of_measuring
                "Users" - User
                "Notification Templates" - NotificationPage
                "Tracks" - Track
        */
        List<WebElement>  navItems = findElementsByCSS(ADMIN_MENU_CSS);
        for (WebElement navItem : navItems) {
            if (navItem.getText().equals(pageName)) {
                navItem.click();
                break;
            }
        }
    }

}
