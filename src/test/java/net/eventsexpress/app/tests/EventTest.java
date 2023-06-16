package net.eventsexpress.app.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import net.eventsexpress.app.pages.EventDetailsPage;
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
                .assertUserLoggedIn()
        .navigateTo(LandingPage.class)
                .clickOnFindEventButton()
        .navigateTo(EventsPage.class)
                .assertEventsPageOpened();
    }

    @Test(priority = 2)
    @Description("Authorized user can open event details")
    @Story("Verifying event details test")
    public void verifyUpcomingEventDetails() {
        new Header()
                .login(admin)
                .assertUserLoggedIn()
        .navigateTo(LandingPage.class)
                .clickOnFindEventButton()
        .navigateTo(EventsPage.class)
                .openEventDetails()
                .assertUpcomingEventDetails();
    }

    @Test(priority = 3)
    @Description("Authorized user can add comment to the event")
    @Story("Add comment to the event test")
    public void addCommentToEventDetails() {
        new Header()
                .login(admin)
                .assertUserLoggedIn()
        .navigateTo(LandingPage.class)
                .clickOnFindEventButton()
        .navigateTo(EventsPage.class)
                .openEventDetails()
        .navigateTo(EventDetailsPage.class)
                .addCommentToEvent()
                .assertAddedComment();
    }

}
