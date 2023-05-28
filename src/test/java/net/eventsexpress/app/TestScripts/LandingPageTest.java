package net.eventsexpress.app.TestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.eventsexpress.app.Common.BasePage;
import net.eventsexpress.app.TestConfig.TestSetUp;

public class LandingPageTest extends TestSetUp{
    // Sample test class

    @BeforeMethod
    public void setUp() {
        base = new BasePage(getDriver());
    }

     @Test
    public void validLoginTest() {
        base.goToSite();
        base.landing.login(EMAIL, PASSWORD);
        sleep(1000);
        Assert.assertTrue(base.header.isUserLoggedIn());
    }


    @Test
    public void invalidLoginTest() {
        base.goToSite();
        Assert.assertEquals(base.landing.login(NEW_EMAIL, NEW_PASSWORD),  "Incorrect login or password");
        sleep(1000);
        Assert.assertFalse(base.header.isUserLoggedIn());
    }

    @Test
    public void registerTest() {
        String expected = "Your register was successfull. Please confirm your email.";
        base.goToSite();
        Assert.assertEquals(base.landing.register(NEW_EMAIL, NEW_PASSWORD), expected);
        sleep(1000);
    }

    @AfterMethod
    public void tearDown() {
        base.quit();
    }

}
