package net.eventsexpress.app.tests;

import net.eventsexpress.app.driver.DriverManager;
import net.eventsexpress.app.pages.Footer;
import net.eventsexpress.app.pages.footerpages.TermsPage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TermsPageTest extends BaseTest {

    @Test(priority = 3)
    public void testRedirectionToTermsPage() {
        Footer footer = new Footer();
        assertThat(footer.isTermsLinkDisplayed())
                .overridingErrorMessage("Terms link is not displayed in the footer at %s", DriverManager.getDriver().getCurrentUrl())
                .isTrue();
        footer.clickTermsLink();
        TermsPage termsPage = new TermsPage();
        String termsHeading = termsPage.getTermsHeading();
        assertThat(termsHeading)
                .overridingErrorMessage("Terms heading is not displayed at %s", DriverManager.getDriver().getCurrentUrl())
                .isNotNull();
    }
}
