package net.eventsexpress.app.TestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.eventsexpress.app.Common.BasePage;
import net.eventsexpress.app.Utils.Utils;
import net.eventsexpress.app.TestConfig.TestSetUp;

public class LandingPageTest extends TestSetUp{
    // Sample test class

    @BeforeMethod
    public void setUp() {
        base = new BasePage(TestSetUp.getDriver());
    }

     @Test
    public void loginTest() {
        base.goToSite();
        base.landingPage.login(EMAIL, PASSWORD);
        Utils.sleep(1000);
        Assert.assertTrue(base.header.isUserLoggedIn());
    }

    @AfterMethod
    public void tearDown() {
        base.quit();
    }
}
