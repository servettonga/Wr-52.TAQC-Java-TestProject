package net.eventexpress.app.Pages;

import net.eventexpress.app.Common.BaseWrapper;

public class LandingPage extends BaseWrapper{
    String EVENT_EXPRESS_LOGO_CSS = "#EEButton";
    String PRIVACY_LINK_XPATH = "//div[@class='links-to-pages']//a[@href='/privacy']";

    public void eventExpressButton() {
        findElementByCSS(EVENT_EXPRESS_LOGO_CSS).click();
    }

    public void scrollToFooter() {
        scrollToElementXpath(PRIVACY_LINK_XPATH);
    }
}
