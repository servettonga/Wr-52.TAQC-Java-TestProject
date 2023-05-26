package net.eventsexpress.app.Common;


import org.openqa.selenium.WebDriver;

import net.eventsexpress.app.Pages.Footer;
import net.eventsexpress.app.Pages.Header;
import net.eventsexpress.app.Pages.LandingPage;

public class BasePage extends BaseWrapper{
    public LandingPage landingPage;
    public Footer footer;
    public Header header;

    public BasePage(WebDriver driver){
        super(driver);
        landingPage = new LandingPage(driver);
        footer = new Footer(driver);
        header = new Header(driver);
    }

}
