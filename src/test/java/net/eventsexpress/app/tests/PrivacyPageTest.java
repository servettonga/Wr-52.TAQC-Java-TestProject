package net.eventsexpress.app.tests;

import net.eventsexpress.app.pages.Footer;
import net.eventsexpress.app.pages.footerpages.PrivacyPage;
import org.testng.annotations.Test;

public class PrivacyPageTest extends BaseTest {
    @Test
    public void testThatUserIsRedirectedToPrivacyPolicyPage() {
        new Footer()
                .navigateToPrivacyPage();
        new PrivacyPage()
                .assertPrivacyHeadingIsDisplayed();
    }

}








