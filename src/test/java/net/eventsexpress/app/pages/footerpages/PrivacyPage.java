package net.eventsexpress.app.pages.footerpages;

import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PrivacyPage extends BasePage {
    protected static final String PRIVACY_HEADING_CSS = ".privacy h1";

    @FindBy(css = PRIVACY_HEADING_CSS)
    private WebElement privacyHeading;


    public String getPrivacyHeading() {
        return privacyHeading.getText();
    }

    @Step("Assert Privacy Heading is displayed")
    public PrivacyPage assertPrivacyHeadingIsDisplayed() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOf(privacyHeading));
        assertThat(heading.isDisplayed())
                    .withFailMessage("Privacy Heading  is not displayed").isTrue();
        return this;
    }

}
