package net.eventsexpress.app.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import net.eventsexpress.app.driver.DriverManager;
import net.eventsexpress.app.pages.Footer;
import net.eventsexpress.app.pages.footerpages.TermsPage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TermsPageTest extends BaseTest {

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Story("Terms Page Navigation")
    @Description("Checks navigation to Terms Page and heading visibility")
    public void testRedirectionToTermsPage() {
        Footer footer = new Footer();
        footer.clickTermsLink();
        TermsPage termsPage = new TermsPage();
        String termsHeading = termsPage.getTermsHeadingText();
        assertThat(termsHeading)
                .overridingErrorMessage("Terms heading is not displayed at %s", DriverManager.getDriver().getCurrentUrl())
                .isNotNull();
    }
}
