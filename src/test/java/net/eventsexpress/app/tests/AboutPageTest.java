package net.eventsexpress.app.tests;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.Footer;

public class AboutPageTest extends BaseTest{
    @Test
    @Story("Footer pages navigation")
    @Description("Assert that About Page link navigates to About Page and heading is visible")
    public void testUserIsRedirectedToAboutPage(){
        new Footer()
                .navigateToAboutPage()
                .assertAboutPageHeadingIsDisplayed();

    }

}
