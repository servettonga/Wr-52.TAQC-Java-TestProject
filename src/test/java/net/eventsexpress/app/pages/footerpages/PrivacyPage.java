package net.eventsexpress.app.pages.footerpages;

import net.eventsexpress.app.base.Base;

public class PrivacyPage {
    protected static String PRIVACY_HEADING_CSS = ".privacy h1";

    public String getPrivacyHeading() {
        return Base.findElementByCSS(PRIVACY_HEADING_CSS).getText();
    }

}
