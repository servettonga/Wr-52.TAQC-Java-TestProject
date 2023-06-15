package net.eventsexpress.app.common;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import net.eventsexpress.app.pages.LandingPage;

public class BasePage {
    protected static final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    protected static final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public <Page extends BasePage> Page navigateTo(Class<Page> page) {
        try {
            return page.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Navigate to Home Page")
    public LandingPage navigateToHomePage() {
        DriverManager.goToSite();
        return new LandingPage();
    }
}
