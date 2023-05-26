package net.eventsexpress.app.Pages;

import org.openqa.selenium.WebDriver;

import net.eventsexpress.app.Common.BaseWrapper;

public class Header extends BaseWrapper{
    String EVENT_EXPRESS_LOGO_CSS = "#EEButton";
    String SIGN_IN_UP_BTN_CSS = "#headbtn";
    String LOG_OUT_BTN_CSS = "div.text-right > div";

    public void eventExpressButton() {
        findElementByCSS(EVENT_EXPRESS_LOGO_CSS).click();
    }

    public Header(WebDriver driver) {
        super(driver);
    }

}
