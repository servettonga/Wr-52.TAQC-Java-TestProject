package net.eventsexpress.app.pages.footerpages;

import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TermsPage {
    private final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    protected static final String TERMS_HEADING_CSS = ".terms h1";

    @FindBy(css = TERMS_HEADING_CSS)
    private WebElement termsHeading;

    public TermsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getTermsHeading() {
        try {
            WebElement visibleTermsHeading = waitForVisibility(termsHeading);
            return visibleTermsHeading.getText();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Terms heading is not displayed or enabled");
        }
    }

    public WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
