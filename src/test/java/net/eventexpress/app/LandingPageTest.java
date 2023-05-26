package net.eventexpress.app;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.eventexpress.app.Pages.LandingPage;
import net.eventexpress.app.Utils.Utils;

public class LandingPageTest {
    LandingPage landing;

    @BeforeMethod
    public void setUp() {
        landing = new LandingPage();
    }

    @Test
    public void testLandingPage() {
        landing.goToSite();
        landing.eventExpressButton();
    }

    @Test
    public void scrollTest() {
        landing.goToSite();
        landing.scrollToFooter();
        Utils.sleep(1000);
    }

    @AfterMethod
    public void tearDown() {
        landing.quit();
    }
}
