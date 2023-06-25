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
    @Story("Navigation to Events Page")
    @Description("Assert that authorized user can open event page after click on Find event button")
    public void verifyUpcomingEventsPage() {
        new Header()
                .login(regularUser)
                .assertUserLoggedIn()
                .navigateTo(LandingPage.class)
                .clickOnFindEventButton()
                .navigateTo(EventsPage.class)
                .assertEventsPageOpened();
    }

    @Test(priority = 2)
    @Story("Navigation to Events Page")
    @Description("Assert that authorized user can open event details")
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
    @Story("Event Page details")
    @Description("Assert that an authorized user can add comment to an event")
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
