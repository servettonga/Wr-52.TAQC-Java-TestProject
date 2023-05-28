package net.eventsexpress.app.Common;


import org.openqa.selenium.WebDriver;

import net.eventsexpress.app.Pages.AdminPanel;
import net.eventsexpress.app.Pages.EventDetails;
import net.eventsexpress.app.Pages.Footer;
import net.eventsexpress.app.Pages.Header;
import net.eventsexpress.app.Pages.Landing;
import net.eventsexpress.app.Pages.Navigation;
import net.eventsexpress.app.Pages.FooterPages.Privacy;

public class BasePage extends BaseWrapper {
    public AdminPanel adminPanel;
    public EventDetails eventDetails;
    public Footer footer;
    public Header header;
    public Landing landing;
    public Navigation navigation;

    public Privacy privacy;

    public BasePage(WebDriver driver) {
        super(driver);
        adminPanel = new AdminPanel(driver);
        eventDetails = new EventDetails(driver);
        footer = new Footer(driver);
        header = new Header(driver);
        landing = new Landing(driver);
        navigation = new Navigation(driver);
        privacy = new Privacy(driver);
    }

}
