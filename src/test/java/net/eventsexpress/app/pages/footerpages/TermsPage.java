package net.eventsexpress.app.pages.footerpages;

import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Step;
import java.time.Duration;
import net.eventsexpress.app.common.BasePage;
import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TermsPage extends BasePage {

    @FindBy(css = ".terms h1")
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

    @Step("Assert that Terms Heading is displayed")
    public void assertThatTermsHeadingIsDisplayed() {
        assertThat(getTermsHeadingText())
            .overridingErrorMessage("Terms heading is not displayed at %s", DriverManager.getDriver().getCurrentUrl())
            .isNotNull();
    }

}
