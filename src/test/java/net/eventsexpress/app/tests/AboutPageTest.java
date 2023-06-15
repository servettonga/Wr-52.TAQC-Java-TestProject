package net.eventsexpress.app.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.Footer;
import net.eventsexpress.app.pages.footerpages.AboutPage;
import org.testng.annotations.Test;

public class AboutPageTest extends BaseTest{
    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Story("About Page Navigation")
    @Description("Checks navigation to About Page and heading visibility")
    public void testUserIsRedirectedToAboutPage(){
        new Footer()
                .navigateToAboutPage();
        new AboutPage()
                .assertAboutPageHeadingIsDisplayed();

    }
}
