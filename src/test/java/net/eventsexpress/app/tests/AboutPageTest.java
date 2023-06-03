package net.eventsexpress.app.tests;

import net.eventsexpress.app.pages.Footer;
import net.eventsexpress.app.pages.footerpages.AboutPage;
import org.testng.annotations.Test;

public class AboutPageTest extends BaseTest{
    @Test
    public void testUserIsRedirectedToAboutPage(){
        new Footer()
                .navigateToAboutPage();
        new AboutPage()
                .assertAboutPageHeadingIsDisplayed();

    }
}
