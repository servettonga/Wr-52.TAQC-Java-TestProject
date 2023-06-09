package net.eventsexpress.app.pages.footerpages;

import io.qameta.allure.Step;
import java.time.Duration;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AboutPage {
    private final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    private final WebDriverWait wait =
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
    protected static final String ABOUT_PAGE_HEADING_CSS = ".about h1";

    public AboutPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(css = ABOUT_PAGE_HEADING_CSS)
    private WebElement aboutPageHeading;

    public String getAboutPageHeading() {
        return aboutPageHeading.getText();

    }

    @Step("Assert About Page heading is displayed")
    public AboutPage assertAboutPageHeadingIsDisplayed() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOf(aboutPageHeading));
        assert heading.isDisplayed() : "About Page Heading  is not displayed";
        return this;
    }

}
