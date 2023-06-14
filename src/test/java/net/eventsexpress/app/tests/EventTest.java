package net.eventsexpress.app.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.EventsPage;
import net.eventsexpress.app.pages.Header;
import net.eventsexpress.app.pages.LandingPage;
import org.testng.annotations.Test;


public class EventTest extends BaseTest {

    @Test(priority = 1)
    @Description("Authorized user can open event page after click on Find event button")
    @Story("Navigation to Event page test")
    public void verifyUpcomingEventsPage() {
        new Header()
                .login(admin)
                .assertUserLoggedIn();
        new LandingPage()
                .clickOnFindEventButton();
        new EventsPage()
                .assertEventsPageOpened();
    }

    @Test(priority = 2)
    @Description("Authorized user can open event details")
    @Story("Verifying event details test")
    public void verifyUpcomingEventDetails() {
        new Header()
                .login(admin)
                .assertUserLoggedIn();
        new LandingPage()
                .clickOnFindEventButton();
        new EventsPage()
                .openEventDetails()
                .assertUpcomingEventDetails();
    }
}
