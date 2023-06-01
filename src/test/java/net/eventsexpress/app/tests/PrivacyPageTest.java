package net.eventsexpress.app.tests;

import net.eventsexpress.app.pages.Footer;
import net.eventsexpress.app.pages.footerpages.PrivacyPage;
import org.testng.annotations.Test;

public class PrivacyPageTest extends BaseTest{
    Footer footer=new Footer();
    @Test
    public void testThatUserIsRedirectedToPrivacyPolicyPage() {
        footer.scrollToFooter();
        footer.click_privacy_link();
        PrivacyPage.assertPrivacyHeadingIsDisplayed();




    }



}
