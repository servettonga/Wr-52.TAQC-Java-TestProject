package net.eventsexpress.app.pages.footerpages;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;
import net.eventsexpress.app.driver.DriverManager;


public class TermsPage extends BasePage {
    protected static final String TERMS_HEADING_CSS = ".terms h1";

    @FindBy(css = TERMS_HEADING_CSS)
    private WebElement termsHeading;


    public String getTermsHeadingText() {
        try {
            WebElement visibleTermsHeading = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(termsHeading));
            return visibleTermsHeading.getText();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Terms heading is not displayed or enabled");
        }
    }

    @Step("Assert Terms Heading is displayed")
    public void assertThatTermsHeadingIsDisplayed() {
        assertThat(getTermsHeadingText())
            .overridingErrorMessage("Terms heading is not displayed at %s", DriverManager.getDriver().getCurrentUrl())
            .isNotNull();
    }

}
