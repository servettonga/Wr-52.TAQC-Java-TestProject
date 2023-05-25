package net.eventexpress.app;

import org.testng.annotations.Test;

import net.eventexpress.app.Pages.LandingPage;

public class LandingPageTest {
    LandingPage landing = new LandingPage();

    @Test
    public void testLandingPage() {
        landing.goToSite();
        landing.eventExpressButton();
    }
}
