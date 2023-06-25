package net.eventsexpress.app.tests;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.Footer;

public class TermsPageTest extends BaseTest {

    @Test
    @Story("Footer pages navigation")
    @Description("Assert that Terms Page link navigates to Terms Page and heading is visible")
    public void testRedirectionToTermsPage() {
        new Footer()
            .clickTermsLink()
            .assertThatTermsHeadingIsDisplayed();
    }

}
