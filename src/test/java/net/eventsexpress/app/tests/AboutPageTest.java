package net.eventsexpress.app.tests;

import org.testng.annotations.Test;
import net.eventsexpress.app.pages.Footer;

public class AboutPageTest extends BaseTest{
    @Test
    public void testUserIsRedirectedToAboutPage(){
        new Footer()
                .navigateToAboutPage()
                .assertAboutPageHeadingIsDisplayed();

    }
}
