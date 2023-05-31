package net.eventsexpress.app.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.eventsexpress.app.base.Base;

public class LandingPage {
    // Hero
    protected static String CREATE_EVENT_BTN_XPATH = "//button[contains(text(), 'Create event')]";
    protected static String FIND_EVENT_BTN_XPATH = "//a[text()='Find event']";
    protected static String JOIN_EVENTSEXPRESS_BTN_XPATH = "//button[text()='Join EventsExpress']";
    // Upcoming Events
    protected static String JOIN_EVENT_BTN_XPATH = "//a[text()='Join event']";
    protected static String EXPlORE_MORE_EVENTS_BTN_XPATH = "//a[text()='Explore more events']";
    // UI
    protected static String BACKGROUND_IMAGE_CSS = "article[style~='background-image:']";

    public static String getBackgroundImage() {
        Pattern pattern = Pattern.compile("\\/([^\\/]+\\.jpg)");
        String input = Base.findElementByCSS(BACKGROUND_IMAGE_CSS).getAttribute("style");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

}
