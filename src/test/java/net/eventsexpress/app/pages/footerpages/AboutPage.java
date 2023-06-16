package net.eventsexpress.app.pages.footerpages;

import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AboutPage extends BasePage {
    protected static final String ABOUT_PAGE_HEADING_CSS = ".about h1";


    @FindBy(css = ABOUT_PAGE_HEADING_CSS)
    private WebElement aboutPageHeading;

    public String getAboutPageHeading() {
        return aboutPageHeading.getText();

    }

    @Step("Assert About Page heading is displayed")
    public AboutPage assertAboutPageHeadingIsDisplayed() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOf(aboutPageHeading));
        assertThat(heading.isDisplayed())
                    .withFailMessage("About Page Heading is not displayed").isTrue();
        return this;
    }

}
