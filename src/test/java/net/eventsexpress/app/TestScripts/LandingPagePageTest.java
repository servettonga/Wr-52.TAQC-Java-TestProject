package net.eventsexpress.app.TestScripts;

import net.eventsexpress.app.Pages.Header;
import net.eventsexpress.app.Pages.LandingPage;
import net.eventsexpress.app.common.ConfigurationManager;
import net.eventsexpress.app.common.DriverManager;
import org.testng.annotations.Test;

import net.eventsexpress.app.TestConfig.BaseTest;

public class LandingPagePageTest extends BaseTest {
    // Sample test class

    @Test
    public void validLoginTest() {
        String baseURL = ConfigurationManager.getConfig().getString("baseURL");
        DriverManager.goToSite(baseURL);

        LandingPage landingPage = new LandingPage();
        landingPage.login(EMAIL, PASSWORD);
        Header header = new Header();
        header.assertUserLoggedIn();
    }

//    @Test
//    public void invalidLoginTest() {
//        base.goToSite();
//        Assert.assertEquals(base.getLanding().login(NEW_EMAIL, NEW_PASSWORD), "Incorrect login or password");
//        sleep(1000);
//        Assert.assertFalse(base.getHeader().isUserLoggedIn());
//    }
//
//    @Test
//    public void registerTest() {
//        String expected = "Your register was successfull. Please confirm your email.";
//        base.goToSite();
//        Assert.assertEquals(base.getLanding().register(NEW_EMAIL, NEW_PASSWORD), expected);
//        sleep(1000);
//    }


}
