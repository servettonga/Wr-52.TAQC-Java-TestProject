package net.eventexpress.app.Pages;

import net.eventexpress.app.Common.BaseWrapper;

public class LandingPage extends BaseWrapper{
    String EVENT_EXPRESS_LOGO_CSS = "#EEButton";

    public LandingPage() {
        super();
    }

    public void eventExpressButton() {
        findElementByCSS(EVENT_EXPRESS_LOGO_CSS).click();
    }
}
