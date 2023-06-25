package net.eventsexpress.app.tests;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.Footer;

public class PrivacyPageTest extends BaseTest {
    @Test
    @Story("Footer pages navigation")
    @Description("Assert that Privacy Page link navigates to Privacy Page and heading is visible")
    public void testThatUserIsRedirectedToPrivacyPolicyPage() {
        new Footer()
                .navigateToPrivacyPage()
                .assertPrivacyHeadingIsDisplayed();
    }

}
