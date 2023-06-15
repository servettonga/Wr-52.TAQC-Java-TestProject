package net.eventsexpress.app.tests;

import org.testng.annotations.Test;
import net.eventsexpress.app.pages.Footer;

public class PrivacyPageTest extends BaseTest {
    @Test
    public void testThatUserIsRedirectedToPrivacyPolicyPage() {
        new Footer()
                .navigateToPrivacyPage()
                .assertPrivacyHeadingIsDisplayed();
    }

}
