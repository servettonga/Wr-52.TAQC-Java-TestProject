package net.eventsexpress.app.pages.footerpages;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Step;
import net.eventsexpress.app.common.BasePage;


public class AboutPage extends BasePage {

    @FindBy(css = ".about h1")
    private WebElement aboutPageHeading;


    public String getAboutPageHeading() {
        return aboutPageHeading.getText();

    }

    @Step("Assert that About Page heading is displayed")
    public AboutPage assertAboutPageHeadingIsDisplayed() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOf(aboutPageHeading));
        assertThat(heading.isDisplayed())
                    .withFailMessage("About Page Heading is not displayed").isTrue();
        return this;
    }

}
