package net.eventsexpress.app.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.eventsexpress.app.Common.BasePage;
import net.eventsexpress.app.Utils.Utils;
import net.eventsexpress.app.TestConfig.TestSetUp;

public class LandingPageTest {
    // Sample test class
    BasePage base;

    @BeforeMethod
    public void setUp() {
        base = new BasePage(TestSetUp.getDriver());
    }

     @Test
    public void scrollTest() {
        base.goToSite();
        base.footer.scrollToFooter();
        Utils.sleep(1000);
    }

    @Test
    public void eventExpressButton() {
        base.goToSite();
        base.header.eventExpressButton();
        Utils.sleep(1000);
    }

    @AfterMethod
    public void tearDown() {
        base.quit();
    }
}
