package net.eventsexpress.app.Pages.FooterPages;

import net.eventsexpress.app.common.BaseWrapper;

public class Privacy extends BaseWrapper{
    String PRIVACY_HEADING_CSS = ".privacy h1";

    public String getPrivacyHeading() {
        return findElementByCSS(PRIVACY_HEADING_CSS).getText();
    }

}
