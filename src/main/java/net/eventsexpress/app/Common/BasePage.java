package net.eventsexpress.app.Common;


import org.openqa.selenium.WebDriver;

import net.eventsexpress.app.Pages.Footer;
import net.eventsexpress.app.Pages.Header;
import net.eventsexpress.app.Pages.Landing;

public class BasePage extends BaseWrapper {
    public Landing landing;
    public Footer footer;
    public Header header;

    public BasePage(WebDriver driver) {
        super(driver);
        landing = new Landing(driver);
        footer = new Footer(driver);
        header = new Header(driver);
    }

}
