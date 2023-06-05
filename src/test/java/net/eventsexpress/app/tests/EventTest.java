package net.eventsexpress.app.tests;

import net.eventsexpress.app.pages.EventsPage;
import net.eventsexpress.app.pages.Header;
import org.testng.annotations.Test;

import net.eventsexpress.app.pages.LandingPage;

public class EventTest extends BaseTest {

    @Test(priority = 1)
    public void verifyUpcomingEvents() {
        new Header()
                .login(EMAIL, PASSWORD)
                .assertUserLoggedIn();
        new LandingPage()
                .findEvent();
        new EventsPage()
                .assertUpcomingEvents();
    }
}
