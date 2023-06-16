package net.eventsexpress.app.pages.footerpages;

import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Step;
import java.time.Duration;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PrivacyPage {
    private final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    private final WebDriverWait wait =
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
    protected static final String PRIVACY_HEADING_CSS = ".privacy h1";

    @FindBy(css = PRIVACY_HEADING_CSS)
    private WebElement privacyHeading;

    public PrivacyPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

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
