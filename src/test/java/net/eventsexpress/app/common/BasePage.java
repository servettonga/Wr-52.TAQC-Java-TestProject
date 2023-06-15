package net.eventsexpress.app.common;

import java.time.Duration;
import net.eventsexpress.app.config.ConfigurationManager;
import net.eventsexpress.app.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static final int timeout = ConfigurationManager.getConfig().getInt("ELEMENT_TIMEOUT");
    protected static final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}
