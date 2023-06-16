package net.eventsexpress.app.common;

import io.qameta.allure.Step;
import java.time.Duration;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import net.eventsexpress.app.pages.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    protected static final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public <P extends BasePage> P navigateTo(Class<P> page) {
        try {
            return page.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Navigate to Home Page")
    public LandingPage navigateToHomePage() {
        DriverManager.goToHomePage();
        return new LandingPage();
    }

}
