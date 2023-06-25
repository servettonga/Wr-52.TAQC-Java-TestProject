package net.eventsexpress.app.pages.footerpages;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;


public class PrivacyPage extends BasePage {

    @FindBy(css = ".privacy h1")
    private WebElement privacyHeading;


    public String getPrivacyHeading() {
        return privacyHeading.getText();
    }

    @Step("Assert that Privacy Heading is displayed")
    public PrivacyPage assertPrivacyHeadingIsDisplayed() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOf(privacyHeading));
        assertThat(heading.isDisplayed())
                    .withFailMessage("Privacy Heading  is not displayed").isTrue();
        return this;
    }

}
