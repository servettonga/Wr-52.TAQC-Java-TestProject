package net.eventsexpress.app.tests;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.Footer;

public class TermsPageTest extends BaseTest {

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Story("Terms Page Navigation")
    @Description("Checks navigation to Terms Page and heading visibility")
    public void testRedirectionToTermsPage() {
        new Footer()
            .clickTermsLink()
            .assertThatTermsHeadingIsDisplayed();
    }

}
